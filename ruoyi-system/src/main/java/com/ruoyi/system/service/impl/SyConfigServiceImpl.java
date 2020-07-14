package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.system.domain.SyConfig;
import com.ruoyi.system.mapper.SyConfigMapper;
import com.ruoyi.system.service.ISyConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 参数配置 服务层实现
 *
 * @author ruoyi
 * @date 2019-12-28
 */
@Service
public class SyConfigServiceImpl implements ISyConfigService {

    @Autowired
    private SyConfigMapper syConfigMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询参数配置信息
     *
     * @param id 参数配置ID
     * @return 参数配置信息
     */
    @Override
    public SyConfig selectSyConfigById(Integer id) {
//        SyConfig syConfig = syConfigMapper.selectSyConfigById(id);
//        String sTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, syConfig.getStartTime());
//        syConfig.setStartTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD_HH_MM_SS, sTime));
        return syConfigMapper.selectSyConfigById(id);
    }

    /**
     * 查询参数配置列表
     *
     * @param syConfig 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<SyConfig> selectSyConfigList(SyConfig syConfig) {
        return syConfigMapper.selectSyConfigList(syConfig);
    }

    /**
     * 新增参数配置
     *
     * @param syConfig 参数配置信息
     * @return 结果
     */
    @Override
    public int insertSyConfig(SyConfig syConfig) {
        int i = syConfigMapper.insertSyConfig(syConfig);
        cache();
        return i;
    }

    /**
     * 修改参数配置
     *
     * @param syConfig 参数配置信息
     * @return 结果
     */
    @Override
    public int updateSyConfig(SyConfig syConfig) {
        int i = syConfigMapper.updateSyConfig(syConfig);
        cache();
        return i;
    }

    /**
     * 删除参数配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSyConfigByIds(String ids) {
        int i = syConfigMapper.deleteSyConfigByIds(Convert.toStrArray(ids));
        cache();
        return i;
    }

    private void cache() {
        redisTemplate.delete(RedisKey.SY_CONFIG);
        List<SyConfig> scs = this.selectSyConfigList(null);
        Map<String, List<SyConfig>> configs = scs.stream().collect(Collectors.groupingByConcurrent(SyConfig::getConfigKey));
        configs.forEach(new BiConsumer<String, List<SyConfig>>() {
            @Override
            public void accept(String key, List<SyConfig> syConfigs) {
                String subKey = key;
                SyConfig value = syConfigs.get(0);
                redisTemplate.opsForHash().put(RedisKey.SY_CONFIG, subKey, JSONObject.toJSON(value));
            }
        });
    }

}
