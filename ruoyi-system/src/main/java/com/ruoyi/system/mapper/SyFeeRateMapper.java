package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyFeeRate;
import java.util.List;	

/**
 * 收益比率 数据层
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface SyFeeRateMapper 
{
	/**
     * 查询收益比率信息
     * 
     * @param id 收益比率ID
     * @return 收益比率信息
     */
	public SyFeeRate selectSyFeeRateById(Integer id);
	
	/**
     * 查询收益比率列表
     * 
     * @param syFeeRate 收益比率信息
     * @return 收益比率集合
     */
	public List<SyFeeRate> selectSyFeeRateList(SyFeeRate syFeeRate);
	
	/**
     * 新增收益比率
     * 
     * @param syFeeRate 收益比率信息
     * @return 结果
     */
	public int insertSyFeeRate(SyFeeRate syFeeRate);
	
	/**
     * 修改收益比率
     * 
     * @param syFeeRate 收益比率信息
     * @return 结果
     */
	public int updateSyFeeRate(SyFeeRate syFeeRate);
	
	/**
     * 删除收益比率
     * 
     * @param id 收益比率ID
     * @return 结果
     */
	public int deleteSyFeeRateById(Integer id);
	
	/**
     * 批量删除收益比率
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyFeeRateByIds(String[] ids);
	
}