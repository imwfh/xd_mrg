package com.ruoyi.system.service;

import com.ruoyi.system.domain.TbProfitUser;
import java.util.List;
import java.util.Map;

/**
 * 用户基本 服务层
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface ITbProfitUserService 
{
	/**
     * 查询用户基本信息
     * 
     * @param userId 用户基本ID
     * @return 用户基本信息
     */
	public TbProfitUser selectTbProfitUserById(Long userId);

	public TbProfitUser selectTbProfitUserByUserCode(String userCode);

	public int updateMoney(Map<String, Object> pram);
	
	/**
     * 查询用户基本列表
     * 
     * @param tbProfitUser 用户基本信息
     * @return 用户基本集合
     */
	public List<TbProfitUser> selectTbProfitUserList(TbProfitUser tbProfitUser);
	
	/**
     * 新增用户基本
     * 
     * @param tbProfitUser 用户基本信息
     * @return 结果
     */
	public int insertTbProfitUser(TbProfitUser tbProfitUser);
	
	/**
     * 修改用户基本
     * 
     * @param tbProfitUser 用户基本信息
     * @return 结果
     */
	public int updateTbProfitUser(TbProfitUser tbProfitUser);
		
	/**
     * 删除用户基本信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbProfitUserByIds(String ids);
	
}
