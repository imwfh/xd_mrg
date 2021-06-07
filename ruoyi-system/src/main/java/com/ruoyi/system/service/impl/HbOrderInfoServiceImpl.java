package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HbOrderInfoMapper;
import com.ruoyi.system.domain.HbOrderInfo;
import com.ruoyi.system.service.IHbOrderInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 火币用户下单 服务层实现
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
@Service
public class HbOrderInfoServiceImpl implements IHbOrderInfoService 
{
	@Autowired
	private HbOrderInfoMapper hbOrderInfoMapper;

	/**
     * 查询火币用户下单信息
     * 
     * @param id 火币用户下单ID
     * @return 火币用户下单信息
     */
    @Override
	public HbOrderInfo selectHbOrderInfoById(Integer id)
	{
	    return hbOrderInfoMapper.selectHbOrderInfoById(id);
	}
	
	/**
     * 查询火币用户下单列表
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 火币用户下单集合
     */
	@Override
	public List<HbOrderInfo> selectHbOrderInfoList(HbOrderInfo hbOrderInfo)
	{
	    return hbOrderInfoMapper.selectHbOrderInfoList(hbOrderInfo);
	}
	
    /**
     * 新增火币用户下单
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 结果
     */
	@Override
	public int insertHbOrderInfo(HbOrderInfo hbOrderInfo)
	{
	    return hbOrderInfoMapper.insertHbOrderInfo(hbOrderInfo);
	}
	
	/**
     * 修改火币用户下单
     * 
     * @param hbOrderInfo 火币用户下单信息
     * @return 结果
     */
	@Override
	public int updateHbOrderInfo(HbOrderInfo hbOrderInfo)
	{
	    return hbOrderInfoMapper.updateHbOrderInfo(hbOrderInfo);
	}

	/**
     * 删除火币用户下单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteHbOrderInfoByIds(String ids)
	{
		return hbOrderInfoMapper.deleteHbOrderInfoByIds(Convert.toStrArray(ids));
	}
	
}
