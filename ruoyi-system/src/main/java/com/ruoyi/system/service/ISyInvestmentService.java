package com.ruoyi.system.service;

import com.ruoyi.system.domain.InvestmentRet;
import com.ruoyi.system.domain.SyInvestment;

/**
 * 用户投资 服务层
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface ISyInvestmentService 
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
	public InvestmentRet selectSyInvestmentList(SyInvestment syInvestment);
	
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
     * 删除用户投资信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyInvestmentByIds(String ids);
	
}
