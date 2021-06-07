package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HbUserStrategysMapper;
import com.ruoyi.system.domain.HbUserStrategys;
import com.ruoyi.system.service.IHbUserStrategysService;
import com.ruoyi.common.core.text.Convert;

/**
 * 火币用户策略集 服务层实现
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Service
public class HbUserStrategysServiceImpl implements IHbUserStrategysService 
{
	@Autowired
	private HbUserStrategysMapper hbUserStrategysMapper;

	/**
     * 查询火币用户策略集信息
     * 
     * @param id 火币用户策略集ID
     * @return 火币用户策略集信息
     */
    @Override
	public HbUserStrategys selectHbUserStrategysById(Integer id)
	{
	    return hbUserStrategysMapper.selectHbUserStrategysById(id);
	}
	
	/**
     * 查询火币用户策略集列表
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 火币用户策略集集合
     */
	@Override
	public List<HbUserStrategys> selectHbUserStrategysList(HbUserStrategys hbUserStrategys)
	{
	    return hbUserStrategysMapper.selectHbUserStrategysList(hbUserStrategys);
	}
	
    /**
     * 新增火币用户策略集
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 结果
     */
	@Override
	public int insertHbUserStrategys(HbUserStrategys hbUserStrategys)
	{
	    return hbUserStrategysMapper.insertHbUserStrategys(hbUserStrategys);
	}
	
	/**
     * 修改火币用户策略集
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 结果
     */
	@Override
	public int updateHbUserStrategys(HbUserStrategys hbUserStrategys)
	{
	    return hbUserStrategysMapper.updateHbUserStrategys(hbUserStrategys);
	}

	/**
     * 删除火币用户策略集对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHbUserStrategysByIds(String ids)
	{
		return hbUserStrategysMapper.deleteHbUserStrategysByIds(Convert.toStrArray(ids));
	}
	
}
