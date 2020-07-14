package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyRevAccount;
import com.ruoyi.system.mapper.SyRevAccountMapper;
import com.ruoyi.system.service.ISyRevAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 平台收款账户 服务层实现
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
@Service
public class SyRevAccountServiceImpl implements ISyRevAccountService 
{
	@Autowired
	private SyRevAccountMapper syRevAccountMapper;

	/**
     * 查询平台收款账户信息
     * 
     * @param id 平台收款账户ID
     * @return 平台收款账户信息
     */
    @Override
	public SyRevAccount selectSyRevAccountById(Integer id)
	{
	    return syRevAccountMapper.selectSyRevAccountById(id);
	}
	
	/**
     * 查询平台收款账户列表
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 平台收款账户集合
     */
	@Override
	public List<SyRevAccount> selectSyRevAccountList(SyRevAccount syRevAccount)
	{
	    return syRevAccountMapper.selectSyRevAccountList(syRevAccount);
	}
	
    /**
     * 新增平台收款账户
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 结果
     */
	@Override
	public int insertSyRevAccount(SyRevAccount syRevAccount)
	{
	    return syRevAccountMapper.insertSyRevAccount(syRevAccount);
	}
	
	/**
     * 修改平台收款账户
     * 
     * @param syRevAccount 平台收款账户信息
     * @return 结果
     */
	@Override
	public int updateSyRevAccount(SyRevAccount syRevAccount)
	{
	    return syRevAccountMapper.updateSyRevAccount(syRevAccount);
	}

	/**
     * 删除平台收款账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyRevAccountByIds(String ids)
	{
		return syRevAccountMapper.deleteSyRevAccountByIds(Convert.toStrArray(ids));
	}
	
}
