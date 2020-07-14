package com.ruoyi.system.service;

import com.ruoyi.system.domain.SyRevAccount;
import java.util.List;

/**
 * 平台收款账户 服务层
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public interface ISyRevAccountService 
{
	/**
     * 查询平台收款账户信息
     * 
     * @param id 平台收款账户ID
     * @return 平台收款账户信息
     */
	public SyRevAccount selectSyRevAccountById(Integer id);
	
	/**
     * 查询平台收款账户列表
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 平台收款账户集合
     */
	public List<SyRevAccount> selectSyRevAccountList(SyRevAccount syRevAccount);
	
	/**
     * 新增平台收款账户
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 结果
     */
	public int insertSyRevAccount(SyRevAccount syRevAccount);
	
	/**
     * 修改平台收款账户
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 结果
     */
	public int updateSyRevAccount(SyRevAccount syRevAccount);
		
	/**
     * 删除平台收款账户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyRevAccountByIds(String ids);
	
}
