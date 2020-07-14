package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.SyNotice;
import com.ruoyi.system.mapper.SyNoticeMapper;
import com.ruoyi.system.service.ISyNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 公告 服务层实现
 *
 * @author ruoyi
 * @date 2020-01-03
 */
@Service
public class SyNoticeServiceImpl implements ISyNoticeService {

    @Autowired
    private SyNoticeMapper syNoticeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询公告信息
     *
     * @param id 公告ID
     * @return 公告信息
     */
    @Override
    public SyNotice selectSyNoticeById(Integer id) {
        SyNotice syNotice = syNoticeMapper.selectSyNoticeById(id);
        String hashCode = syNotice.getHashCode();
        List<SyNotice> syNotice2 = syNoticeMapper.selectSyNoticeByHashCode(hashCode);
        Optional<SyNotice> sn = syNotice2.stream().filter(e -> e.getLanguageType() != syNotice.getLanguageType()).findFirst();
        syNotice.setNc(sn.get().getNoticeContent());
        syNotice.setNoticeTitleEn(sn.get().getNoticeTitle());
        return syNotice;
    }

    /**
     * 查询公告列表
     *
     * @param syNotice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SyNotice> selectSyNoticeList(SyNotice syNotice) {
        return syNoticeMapper.selectSyNoticeList(syNotice);
    }

    /**
     * 新增公告
     *
     * @param syNotice 公告信息
     * @return 结果
     */
    @Override
    public int insertSyNotice(SyNotice syNotice) {
        String hashCode = Md5Utils.hash(new Date().toString());
        syNotice.setHashCode(hashCode);
        syNotice.setLanguageType(0);

        SyNotice enNotice = new SyNotice();
        BeanUtils.copyBeanProp(enNotice, syNotice);
        enNotice.setNoticeContent(syNotice.getNc());
        enNotice.setHashCode(hashCode);
        enNotice.setLanguageType(1);

        syNotice.setNc(null);
        enNotice.setNc(null);
        enNotice.setNoticeTitle(syNotice.getNoticeTitleEn());

        int i = syNoticeMapper.insertSyNotice(syNotice);
        int y = syNoticeMapper.insertSyNotice(enNotice);
        cache();
        return i + y;
    }

    /**
     * 修改公告
     *
     * @param syNotice 公告信息
     * @return 结果
     */
    @Override
    public int updateSyNotice(SyNotice syNotice) {

        SyNotice enNotice = new SyNotice();
        BeanUtils.copyBeanProp(enNotice, syNotice);
        enNotice.setNoticeContent(syNotice.getNc());

        syNotice.setNc(null);
        enNotice.setNc(null);

        int i = syNoticeMapper.updateSyNotice(syNotice);
        enNotice.setId(syNotice.getId() + 1);
        enNotice.setNoticeTitle(syNotice.getNoticeTitleEn());
        int y = syNoticeMapper.updateSyNotice(enNotice);
        cache();
        return i + y;
    }

    /**
     * 删除公告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSyNoticeByIds(String ids) {
        SyNotice syNotice = syNoticeMapper.selectSyNoticeById(Integer.parseInt(ids));
        String hashCode = syNotice.getHashCode();
        List<SyNotice> syNotice2 = syNoticeMapper.selectSyNoticeByHashCode(hashCode);
        Set<Integer> sets = syNotice2.stream().collect(Collectors.groupingBy(SyNotice::getId)).keySet();
        List<String> iis = new ArrayList<>();
        sets.stream().forEach(e -> {
            iis.add(String.valueOf(e));
        });
        String[] array = new String[iis.size()];
        iis.toArray(array);
        int i = syNoticeMapper.deleteSyNoticeByIds(array);
        cache();
        return i;
    }


    private void cache() {
        redisTemplate.delete(RedisKey.NOTICE_DATAS);
        List<SyNotice> syNotices = syNoticeMapper.selectSyNoticeList(null);
        syNotices.stream().forEach(e -> {
            String subKey = "";
            Integer type = e.getLanguageType();
            if (1 == type)
                subKey = "en_us-" + e.getId();
            else if (0 == type)
                subKey = "zh_cn-" + e.getId();
            redisTemplate.opsForHash().put(RedisKey.NOTICE_DATAS, subKey, JSONObject.toJSON(e));
        });
    }

}
