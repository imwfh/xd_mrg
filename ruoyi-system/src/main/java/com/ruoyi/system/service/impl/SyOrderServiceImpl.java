package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyOrder;
import com.ruoyi.system.mapper.SyOrderMapper;
import com.ruoyi.system.service.ISyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购订单 服务层实现
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
@Service
public class SyOrderServiceImpl implements ISyOrderService 
{
	@Autowired
	private SyOrderMapper syOrderMapper;

	/**
     * 查询采购订单信息
     * 
     * @param id 采购订单ID
     * @return 采购订单信息
     */
    @Override
	public SyOrder selectSyOrderById(Integer id)
	{
	    return syOrderMapper.selectSyOrderById(id);
	}
	
	/**
     * 查询采购订单列表
     * 
     * @param syOrder 采购订单信息
     * @return 采购订单集合
     */
	@Override
	public List<SyOrder> selectSyOrderList(SyOrder syOrder)
	{
	    return syOrderMapper.selectSyOrderList(syOrder);
	}
	
    /**
     * 新增采购订单
     * 
     * @param syOrder 采购订单信息
     * @return 结果
     */
	@Override
	public int insertSyOrder(SyOrder syOrder)
	{
	    return syOrderMapper.insertSyOrder(syOrder);
	}
	
	/**
     * 修改采购订单
     * 
     * @param syOrder 采购订单信息
     * @return 结果
     */
	@Override
	public int updateSyOrder(SyOrder syOrder)
	{
	    return syOrderMapper.updateSyOrder(syOrder);
	}

	/**
     * 删除采购订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyOrderByIds(String ids)
	{
		return syOrderMapper.deleteSyOrderByIds(Convert.toStrArray(ids));
	}
	
}
