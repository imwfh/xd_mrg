package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.system.domain.SyGoodsAttr;
import com.ruoyi.system.mapper.SyGoodsAttrMapper;
import com.ruoyi.system.service.ISyGoodsAttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性 服务层实现
 *
 * @author ruoyi
 * @date 2019-08-02
 */
@Service
public class SyGoodsAttrServiceImpl implements ISyGoodsAttrService {

    @Autowired
    private SyGoodsAttrMapper syGoodsAttrMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询商品属性信息
     *
     * @param id 商品属性ID
     * @return 商品属性信息
     */
    @Override
    public SyGoodsAttr selectSyGoodsAttrById(Integer id) {
        return syGoodsAttrMapper.selectSyGoodsAttrById(id);
    }

    /**
     * 查询商品属性列表
     *
     * @param syGoodsAttr 商品属性信息
     * @return 商品属性集合
     */
    @Override
    public List<SyGoodsAttr> selectSyGoodsAttrList(SyGoodsAttr syGoodsAttr) {
        return syGoodsAttrMapper.selectSyGoodsAttrList(syGoodsAttr);
    }

    /**
     * 新增商品属性
     *
     * @param syGoodsAttr 商品属性信息
     * @return 结果
     */
    @Override
    public int insertSyGoodsAttr(SyGoodsAttr syGoodsAttr) {
        syGoodsAttr.setGoodsDetailImgs(removeDHSubImg(syGoodsAttr.getGoodsDetailImgs()));
        syGoodsAttr.setGoodsDetailReport(removeDHSubImg(syGoodsAttr.getGoodsDetailReport()));

        String goodsSn = syGoodsAttr.getGoodsSn();
        String jsonVlaue = JSONObject.toJSONString(syGoodsAttr);
        redisTemplate.opsForHash().put(RedisKey.GOODS_ATTR, goodsSn, jsonVlaue);

        return syGoodsAttrMapper.insertSyGoodsAttr(syGoodsAttr);
    }

    /**
     * 修改商品属性
     *
     * @param syGoodsAttr 商品属性信息
     * @return 结果
     */
    @Override
    public int updateSyGoodsAttr(SyGoodsAttr syGoodsAttr) {

        syGoodsAttr.setGoodsDetailImgs(removeDHSubImg(syGoodsAttr.getGoodsDetailImgs()));
        syGoodsAttr.setGoodsDetailReport(removeDHSubImg(syGoodsAttr.getGoodsDetailReport()));

        String goodsSn = syGoodsAttr.getGoodsSn();
        redisTemplate.opsForHash().delete(RedisKey.GOODS_ATTR, goodsSn);
        String jsonVlaue = JSONObject.toJSONString(syGoodsAttr);
        redisTemplate.opsForHash().put(RedisKey.GOODS_ATTR, goodsSn, jsonVlaue);

        return syGoodsAttrMapper.updateSyGoodsAttr(syGoodsAttr);
    }

    private String removeDHSubImg(String img) {
        String sub = img;
        if (StringUtils.isNotEmpty(img)) {
            if (StringUtils.isNotEmpty(sub)) {
                String lastStr = sub.substring(0, 1);
                if (lastStr.equals(",")) {
                    sub = sub.substring(1, sub.length());
                }
            }
        }

        return sub;
    }

    /**
     * 删除商品属性对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSyGoodsAttrByIds(String ids) {
        return syGoodsAttrMapper.deleteSyGoodsAttrByIds(Convert.toStrArray(ids));
    }

    @Override
    public SyGoodsAttr selectSyGoodsAttrByGoodsSn(String goodsSn) {
        return syGoodsAttrMapper.selectSyGoodsAttrByGoodsSn(goodsSn);
    }
}
