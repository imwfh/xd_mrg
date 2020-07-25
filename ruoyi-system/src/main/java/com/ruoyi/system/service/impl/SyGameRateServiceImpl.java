package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.system.domain.SyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SyGameRateMapper;
import com.ruoyi.system.domain.SyGameRate;
import com.ruoyi.system.service.ISyGameRateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户等级 服务层实现
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Service
public class SyGameRateServiceImpl implements ISyGameRateService 
{
	@Autowired
	private SyGameRateMapper syGameRateMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
     * 查询用户等级信息
     * 
     * @param id 用户等级ID
     * @return 用户等级信息
     */
    @Override
	public SyGameRate selectSyGameRateById(Integer id)
	{
	    return syGameRateMapper.selectSyGameRateById(id);
	}
	
	/**
     * 查询用户等级列表
     * 
     * @param syGameRate 用户等级信息
     * @return 用户等级集合
     */
	@Override
	public List<SyGameRate> selectSyGameRateList(SyGameRate syGameRate)
	{
	    return syGameRateMapper.selectSyGameRateList(syGameRate);
	}
	
    /**
     * 新增用户等级
     * 
     * @param syGameRate 用户等级信息
     * @return 结果
     */
	@Override
	public int insertSyGameRate(SyGameRate syGameRate)
	{
		int i =syGameRateMapper.insertSyGameRate(syGameRate);
		cache();
	    return i;
	}
	
	/**
     * 修改用户等级
     * 
     * @param syGameRate 用户等级信息
     * @return 结果
     */
	@Override
	public int updateSyGameRate(SyGameRate syGameRate)
	{
		int i = syGameRateMapper.updateSyGameRate(syGameRate);
		cache();
	    return i;
	}

	/**
     * 删除用户等级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyGameRateByIds(String ids)
	{
		int i = syGameRateMapper.deleteSyGameRateByIds(Convert.toStrArray(ids));
		cache();
		return i;
	}

	private void cache() {
		redisTemplate.delete(RedisKey.SY_GAME_RATE_);
		List<SyGameRate> scs = this.selectSyGameRateList(null);
		Map<Integer, List<SyGameRate>> configs = scs.stream().collect(Collectors.groupingByConcurrent(SyGameRate::getGradeNum));
		configs.forEach(new BiConsumer<Integer, List<SyGameRate>>() {
			@Override
			public void accept(Integer key, List<SyGameRate> syConfigs) {
				String subKey = key + "";
				SyGameRate value = syConfigs.get(0);
				redisTemplate.opsForHash().put(RedisKey.SY_GAME_RATE_, subKey, JSONObject.toJSON(value));
			}
		});
	}
	
}
