package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HbOrderInfo;
import java.util.List;	

/**
 * 火币用户下单 数据层
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public interface HbOrderInfoMapper 
{
	/**
     * 查询火币用户下单信息
     * 
     * @param id 火币用户下单ID
     * @return 火币用户下单信息
     */
	public HbOrderInfo selectHbOrderInfoById(Integer id);
	
	/**
     * 查询火币用户下单列表
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 火币用户下单集合
     */
	public List<HbOrderInfo> selectHbOrderInfoList(HbOrderInfo hbOrderInfo);
	
	/**
     * 新增火币用户下单
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 结果
     */
	public int insertHbOrderInfo(HbOrderInfo hbOrderInfo);
	
	/**
     * 修改火币用户下单
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 结果
     */
	public int updateHbOrderInfo(HbOrderInfo hbOrderInfo);
	
	/**
     * 删除火币用户下单
     * 
     * @param id 火币用户下单ID
     * @return 结果
     */
	public int deleteHbOrderInfoById(Integer id);
	
	/**
     * 批量删除火币用户下单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHbOrderInfoByIds(String[] ids);
	
}