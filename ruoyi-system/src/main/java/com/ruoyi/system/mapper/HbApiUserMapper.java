package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HbApiUser;
import java.util.List;	

/**
 * 火币用户授权 数据层
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public interface HbApiUserMapper 
{
	/**
     * 查询火币用户授权信息
     * 
     * @param id 火币用户授权ID
     * @return 火币用户授权信息
     */
	public HbApiUser selectHbApiUserById(Integer id);
	
	/**
     * 查询火币用户授权列表
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 火币用户授权集合
     */
	public List<HbApiUser> selectHbApiUserList(HbApiUser hbApiUser);
	
	/**
     * 新增火币用户授权
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 结果
     */
	public int insertHbApiUser(HbApiUser hbApiUser);
	
	/**
     * 修改火币用户授权
     * 
     * @param hbApiUser 火币用户授权信息
     * @return 结果
     */
	public int updateHbApiUser(HbApiUser hbApiUser);
	
	/**
     * 删除火币用户授权
     * 
     * @param id 火币用户授权ID
     * @return 结果
     */
	public int deleteHbApiUserById(Integer id);
	
	/**
     * 批量删除火币用户授权
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHbApiUserByIds(String[] ids);
	
}