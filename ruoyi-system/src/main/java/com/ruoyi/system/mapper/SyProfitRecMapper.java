package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyProfitRec;
import java.util.List;	

/**
 * 用户投资收益 数据层
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface SyProfitRecMapper 
{
	/**
     * 查询用户投资收益信息
     * 
     * @param id 用户投资收益ID
     * @return 用户投资收益信息
     */
	public SyProfitRec selectSyProfitRecById(Integer id);
	
	/**
     * 查询用户投资收益列表
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 用户投资收益集合
     */
	public List<SyProfitRec> selectSyProfitRecList(SyProfitRec syProfitRec);
	
	/**
     * 新增用户投资收益
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 结果
     */
	public int insertSyProfitRec(SyProfitRec syProfitRec);
	
	/**
     * 修改用户投资收益
     * 
     * @param syProfitRec 用户投资收益信息
     * @return 结果
     */
	public int updateSyProfitRec(SyProfitRec syProfitRec);
	
	/**
     * 删除用户投资收益
     * 
     * @param id 用户投资收益ID
     * @return 结果
     */
	public int deleteSyProfitRecById(Integer id);
	
	/**
     * 批量删除用户投资收益
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyProfitRecByIds(String[] ids);
	
}