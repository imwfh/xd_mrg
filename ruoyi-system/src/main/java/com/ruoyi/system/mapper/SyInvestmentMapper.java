package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyInvestment;
import java.util.List;	

/**
 * 用户投资 数据层
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface SyInvestmentMapper 
{
	/**
     * 查询用户投资信息
     * 
     * @param id 用户投资ID
     * @return 用户投资信息
     */
	public SyInvestment selectSyInvestmentById(Integer id);
	
	/**
     * 查询用户投资列表
     * 
     * @param syInvestment 用户投资信息
     * @return 用户投资集合
     */
	public List<SyInvestment> selectSyInvestmentList(SyInvestment syInvestment);
	
	/**
     * 新增用户投资
     * 
     * @param syInvestment 用户投资信息
     * @return 结果
     */
	public int insertSyInvestment(SyInvestment syInvestment);
	
	/**
     * 修改用户投资
     * 
     * @param syInvestment 用户投资信息
     * @return 结果
     */
	public int updateSyInvestment(SyInvestment syInvestment);
	
	/**
     * 删除用户投资
     * 
     * @param id 用户投资ID
     * @return 结果
     */
	public int deleteSyInvestmentById(Integer id);
	
	/**
     * 批量删除用户投资
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyInvestmentByIds(String[] ids);
	
}