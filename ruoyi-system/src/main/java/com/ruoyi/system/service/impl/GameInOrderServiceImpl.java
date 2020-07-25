package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GameInOrderMapper;
import com.ruoyi.system.domain.GameInOrder;
import com.ruoyi.system.service.IGameInOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户下zhu记录 服务层实现
 * 
 * @author ruoyi
 * @date 2020-07-25
 */
@Service
public class GameInOrderServiceImpl implements IGameInOrderService 
{
	@Autowired
	private GameInOrderMapper gameInOrderMapper;

	/**
     * 查询用户下zhu记录信息
     * 
     * @param id 用户下zhu记录ID
     * @return 用户下zhu记录信息
     */
    @Override
	public GameInOrder selectGameInOrderById(Integer id)
	{
	    return gameInOrderMapper.selectGameInOrderById(id);
	}
	
	/**
     * 查询用户下zhu记录列表
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 用户下zhu记录集合
     */
	@Override
	public List<GameInOrder> selectGameInOrderList(GameInOrder gameInOrder)
	{
	    return gameInOrderMapper.selectGameInOrderList(gameInOrder);
	}
	
    /**
     * 新增用户下zhu记录
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 结果
     */
	@Override
	public int insertGameInOrder(GameInOrder gameInOrder)
	{
	    return gameInOrderMapper.insertGameInOrder(gameInOrder);
	}
	
	/**
     * 修改用户下zhu记录
     * 
     * @param gameInOrder 用户下zhu记录信息
     * @return 结果
     */
	@Override
	public int updateGameInOrder(GameInOrder gameInOrder)
	{
	    return gameInOrderMapper.updateGameInOrder(gameInOrder);
	}

	/**
     * 删除用户下zhu记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGameInOrderByIds(String ids)
	{
		return gameInOrderMapper.deleteGameInOrderByIds(Convert.toStrArray(ids));
	}
	
}
