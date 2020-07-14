package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbUserMapper;
import com.ruoyi.system.domain.TbUser;
import com.ruoyi.system.service.ITbUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-06-29
 */
@Service
public class TbUserServiceImpl implements ITbUserService 
{
	@Autowired
	private TbUserMapper tbUserMapper;

	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
    @Override
	public TbUser selectTbUserById(Long userId)
	{
	    return tbUserMapper.selectTbUserById(userId);
	}
	
	/**
     * 查询用户列表
     * 
     * @param tbUser 用户信息
     * @return 用户集合
     */
	@Override
	public List<TbUser> selectTbUserList(TbUser tbUser)
	{
	    return tbUserMapper.selectTbUserList(tbUser);
	}
	
    /**
     * 新增用户
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
	@Override
	public int insertTbUser(TbUser tbUser)
	{
	    return tbUserMapper.insertTbUser(tbUser);
	}
	
	/**
     * 修改用户
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
	@Override
	public int updateTbUser(TbUser tbUser)
	{
	    return tbUserMapper.updateTbUser(tbUser);
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbUserByIds(String ids)
	{
		return tbUserMapper.deleteTbUserByIds(Convert.toStrArray(ids));
	}
	
}
