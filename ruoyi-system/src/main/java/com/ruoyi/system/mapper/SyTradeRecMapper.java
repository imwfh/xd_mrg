package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyTradeRec;
import java.util.List;	

/**
 * 账变记录 数据层
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public interface SyTradeRecMapper 
{
	/**
     * 查询账变记录信息
     * 
     * @param id 账变记录ID
     * @return 账变记录信息
     */
	public SyTradeRec selectSyTradeRecById(Integer id);
	
	/**
     * 查询账变记录列表
     * 
     * @param syTradeRec 账变记录信息
     * @return 账变记录集合
     */
	public List<SyTradeRec> selectSyTradeRecList(SyTradeRec syTradeRec);
	
	/**
     * 新增账变记录
     * 
     * @param syTradeRec 账变记录信息
     * @return 结果
     */
	public int insertSyTradeRec(SyTradeRec syTradeRec);
	
	/**
     * 修改账变记录
     * 
     * @param syTradeRec 账变记录信息
     * @return 结果
     */
	public int updateSyTradeRec(SyTradeRec syTradeRec);
	
	/**
     * 删除账变记录
     * 
     * @param id 账变记录ID
     * @return 结果
     */
	public int deleteSyTradeRecById(Integer id);
	
	/**
     * 批量删除账变记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyTradeRecByIds(String[] ids);
	
}