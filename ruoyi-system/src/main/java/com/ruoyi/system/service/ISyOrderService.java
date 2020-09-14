package com.ruoyi.system.service;

import com.ruoyi.system.domain.SyOrder;
import java.util.List;

/**
 * 采购订单 服务层
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
public interface ISyOrderService 
{
	/**
     * 查询采购订单信息
     * 
     * @param id 采购订单ID
     * @return 采购订单信息
     */
	public SyOrder selectSyOrderById(Integer id);
	
	/**
     * 查询采购订单列表
     * 
     * @param syOrder 采购订单信息
     * @return 采购订单集合
     */
	public List<SyOrder> selectSyOrderList(SyOrder syOrder);
	
	/**
     * 新增采购订单
     * 
     * @param syOrder 采购订单信息
     * @return 结果
     */
	public int insertSyOrder(SyOrder syOrder);
	
	/**
     * 修改采购订单
     * 
     * @param syOrder 采购订单信息
     * @return 结果
     */
	public int updateSyOrder(SyOrder syOrder);
		
	/**
     * 删除采购订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyOrderByIds(String ids);
	
}
