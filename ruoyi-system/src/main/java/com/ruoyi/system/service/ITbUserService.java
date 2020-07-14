package com.ruoyi.system.service;

import com.ruoyi.system.domain.TbUser;
import java.util.List;

/**
 * 用户 服务层
 * 
 * @author ruoyi
 * @date 2019-06-29
 */
public interface ITbUserService 
{
	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
	public TbUser selectTbUserById(Long userId);
	
	/**
     * 查询用户列表
     * 
     * @param tbUser 用户信息
     * @return 用户集合
     */
	public List<TbUser> selectTbUserList(TbUser tbUser);
	
	/**
     * 新增用户
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
	public int insertTbUser(TbUser tbUser);
	
	/**
     * 修改用户
     * 
     * @param tbUser 用户信息
     * @return 结果
     */
	public int updateTbUser(TbUser tbUser);
		
	/**
     * 删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbUserByIds(String ids);
	
}
