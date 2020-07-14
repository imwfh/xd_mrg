package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyProfitRec;
import com.ruoyi.system.mapper.SyProfitRecMapper;
import com.ruoyi.system.service.ISyProfitRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户投资收益 服务层实现
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class SyProfitRecServiceImpl implements ISyProfitRecService 
{
	@Autowired
	private SyProfitRecMapper syProfitRecMapper;

	/**
     * 查询用户投资收益信息
     * 
     * @param id 用户投资收益ID
     * @return 用户投资收益信息
     */
    @Override
	public SyProfitRec selectSyProfitRecById(Integer id)
	{
	    return syProfitRecMapper.selectSyProfitRecById(id);
	}
	
	/**
     * 查询用户投资收益列表
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 用户投资收益集合
     */
	@Override
	public List<SyProfitRec> selectSyProfitRecList(SyProfitRec syProfitRec)
	{
	    return syProfitRecMapper.selectSyProfitRecList(syProfitRec);
	}
	
    /**
     * 新增用户投资收益
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 结果
     */
	@Override
	public int insertSyProfitRec(SyProfitRec syProfitRec)
	{
	    return syProfitRecMapper.insertSyProfitRec(syProfitRec);
	}
	
	/**
     * 修改用户投资收益
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 结果
     */
	@Override
	public int updateSyProfitRec(SyProfitRec syProfitRec)
	{
	    return syProfitRecMapper.updateSyProfitRec(syProfitRec);
	}

	/**
     * 删除用户投资收益对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyProfitRecByIds(String ids)
	{
		return syProfitRecMapper.deleteSyProfitRecByIds(Convert.toStrArray(ids));
	}
	
}
