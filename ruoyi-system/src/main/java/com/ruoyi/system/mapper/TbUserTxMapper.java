package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TbUserTx;
import java.util.List;	

/**
 * 提现记录 数据层
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public interface TbUserTxMapper 
{
	/**
     * 查询提现记录信息
     * 
     * @param id 提现记录ID
     * @return 提现记录信息
     */
	public TbUserTx selectTbUserTxById(Long id);
	
	/**
     * 查询提现记录列表
     * 
     * @param tbUserTx 提现记录信息
     * @return 提现记录集合
     */
	public List<TbUserTx> selectTbUserTxList(TbUserTx tbUserTx);
	
	/**
     * 新增提现记录
     * 
     * @param tbUserTx 提现记录信息
     * @return 结果
     */
	public int insertTbUserTx(TbUserTx tbUserTx);
	
	/**
     * 修改提现记录
     * 
     * @param tbUserTx 提现记录信息
     * @return 结果
     */
	public int updateTbUserTx(TbUserTx tbUserTx);
	
	/**
     * 删除提现记录
     * 
     * @param id 提现记录ID
     * @return 结果
     */
	public int deleteTbUserTxById(Long id);
	
	/**
     * 批量删除提现记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbUserTxByIds(String[] ids);
	
}