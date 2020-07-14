package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.common.utils.UUIDGenUtil;
import com.ruoyi.system.domain.SyGoods;
import com.ruoyi.system.mapper.SyGoodsMapper;
import com.ruoyi.system.service.ISyGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品 服务层实现
 *
 * @author ruoyi
 * @date 2019-07-29
 */
@Service
public class SyGoodsServiceImpl implements ISyGoodsService {

    @Autowired
    private SyGoodsMapper syGoodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询商品信息
     *
     * @param id 商品ID
     * @return 商品信息
     */
    @Override
    public SyGoods selectSyGoodsById(Integer id) {
        return syGoodsMapper.selectSyGoodsById(id);
    }

    /**
     * 查询商品列表
     *
     * @param syGoods 商品信息
     * @return 商品集合
     */
    @Override
    public List<SyGoods> selectSyGoodsList(SyGoods syGoods) {
        List<SyGoods> sg = syGoodsMapper.selectSyGoodsList(syGoods);
        sg.stream().forEach(e -> {
            //0:在售中  -1:下架
            Integer goodsStatus = e.getGoodsStatus();
            String goodsStatusStr = goodsStatus == 0 ? "在售中" : "已下架";
            e.setGoodsStatusStr(goodsStatusStr);
            //是否热销产品	0:否 1:是
            Integer isHot = e.getIsHot();
            String isHotStr = (null == isHot || isHot == 0) ? "否" : "是";
            e.setIsHotStr(isHotStr);

            //是否新品	0:否 1:是
            Integer isNew = e.getIsNew();
            String isNewStr = (null == isNew || isNew == 0) ? "否" : "是";
            e.setIsNewStr(isNewStr);

        });
        return sg;
    }

    /**
     * 新增商品
     *
     * @param syGoods 商品信息
     * @return 结果
     */
    @Override
    public int insertSyGoods(SyGoods syGoods) {

        //生成商品编码
        String goodSn = UUIDGenUtil.getCode();
        syGoods.setGoodsSn(goodSn);
        removeDHSubImg(syGoods);

        //添加到redis
        String jsonVlaue = com.alibaba.fastjson.JSONObject.toJSONString(syGoods);
        redisTemplate.opsForHash().put(RedisKey.GOODS_INFO, goodSn, jsonVlaue);

        return syGoodsMapper.insertSyGoods(syGoods);
    }

    private void removeDHSubImg(SyGoods syGoods) {
        String sub = syGoods.getGoodsSubimg();
        if (StringUtils.isNotEmpty(sub)) {
            String lastStr = sub.substring(0, 1);
            if (lastStr.equals(",")) {
                sub = sub.substring(1, sub.length());
            }
            syGoods.setGoodsSubimg(sub);
        }
    }

    /**
     * 修改商品
     *
     * @param syGoods 商品信息
     * @return 结果
     */
    @Override
    public int updateSyGoods(SyGoods syGoods) {
        //去除sumimg后的逗号
        removeDHSubImg(syGoods);

        redisTemplate.opsForHash().delete(RedisKey.GOODS_INFO, syGoods.getGoodsSn());
        String jsonVlaue = com.alibaba.fastjson.JSONObject.toJSONString(syGoods);
        redisTemplate.opsForHash().put(RedisKey.GOODS_INFO, syGoods.getGoodsSn(), jsonVlaue);

        return syGoodsMapper.updateSyGoods(syGoods);
    }

    public static void main(String[] args) {
        String sub = "1231231,12123";
        String lastStr = sub.substring(0, 1);
        if (lastStr.equals(",")) {
            sub = sub.substring(1, sub.length());
        }


        System.out.println(sub);
    }

    /**
     * 删除商品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSyGoodsByIds(String ids) {
        return syGoodsMapper.deleteSyGoodsByIds(Convert.toStrArray(ids));
    }

}
