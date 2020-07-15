package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyTradeRec;
import com.ruoyi.system.mapper.SyTradeRecMapper;
import com.ruoyi.system.service.ISyTradeRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账变记录 服务层实现
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Service
public class SyTradeRecServiceImpl implements ISyTradeRecService 
{
	@Autowired
	private SyTradeRecMapper syTradeRecMapper;

	/**
     * 查询账变记录信息
     * 
     * @param id 账变记录ID
     * @return 账变记录信息
     */
    @Override
	public SyTradeRec selectSyTradeRecById(Integer id)
	{
	    return syTradeRecMapper.selectSyTradeRecById(id);
	}
	
	/**
     * 查询账变记录列表
     * 
     * @param syTradeRec 账变记录信息
     * @return 账变记录集合
     */
	@Override
	public List<SyTradeRec> selectSyTradeRecList(SyTradeRec syTradeRec)
	{
	    return syTradeRecMapper.selectSyTradeRecList(syTradeRec);
	}
	
    /**
     * 新增账变记录
     * 
     * @param syTradeRec 账变记录信息
     * @return 结果
     */
	@Override
	public int insertSyTradeRec(SyTradeRec syTradeRec)
	{
	    return syTradeRecMapper.insertSyTradeRec(syTradeRec);
	}
	
	/**
     * 修改账变记录
     * 
     * @param syTradeRec 账变记录信息
     * @return 结果
     */
	@Override
	public int updateSyTradeRec(SyTradeRec syTradeRec)
	{
	    return syTradeRecMapper.updateSyTradeRec(syTradeRec);
	}

	/**
     * 删除账变记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyTradeRecByIds(String ids)
	{
		return syTradeRecMapper.deleteSyTradeRecByIds(Convert.toStrArray(ids));
	}
	
}
