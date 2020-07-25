package com.ruoyi.system.service;

import com.ruoyi.system.domain.GameInOrder;
import java.util.List;

/**
 * 用户下zhu记录 服务层
 * 
 * @author ruoyi
 * @date 2020-07-25
 */
public interface IGameInOrderService 
{
	/**
     * 查询用户下zhu记录信息
     * 
     * @param id 用户下zhu记录ID
     * @return 用户下zhu记录信息
     */
	public GameInOrder selectGameInOrderById(Integer id);
	
	/**
     * 查询用户下zhu记录列表
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 用户下zhu记录集合
     */
	public List<GameInOrder> selectGameInOrderList(GameInOrder gameInOrder);
	
	/**
     * 新增用户下zhu记录
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 结果
     */
	public int insertGameInOrder(GameInOrder gameInOrder);
	
	/**
     * 修改用户下zhu记录
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 结果
     */
	public int updateGameInOrder(GameInOrder gameInOrder);
		
	/**
     * 删除用户下zhu记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGameInOrderByIds(String ids);
	
}
