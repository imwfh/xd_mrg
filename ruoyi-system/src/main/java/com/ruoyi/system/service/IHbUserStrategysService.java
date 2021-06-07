package com.ruoyi.system.service;

import com.ruoyi.system.domain.HbUserStrategys;
import java.util.List;

/**
 * 火币用户策略集 服务层
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public interface IHbUserStrategysService 
{
	/**
     * 查询火币用户策略集信息
     * 
     * @param id 火币用户策略集ID
     * @return 火币用户策略集信息
     */
	public HbUserStrategys selectHbUserStrategysById(Integer id);
	
	/**
     * 查询火币用户策略集列表
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 火币用户策略集集合
     */
	public List<HbUserStrategys> selectHbUserStrategysList(HbUserStrategys hbUserStrategys);
	
	/**
     * 新增火币用户策略集
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 结果
     */
	public int insertHbUserStrategys(HbUserStrategys hbUserStrategys);
	
	/**
     * 修改火币用户策略集
     * 
     * @param hbUserStrategys 火币用户策略集信息
     * @return 结果
     */
	public int updateHbUserStrategys(HbUserStrategys hbUserStrategys);
		
	/**
     * 删除火币用户策略集信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHbUserStrategysByIds(String ids);
	
}
