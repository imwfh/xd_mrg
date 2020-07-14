package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyConfig;
import java.util.List;	

/**
 * 参数配置 数据层
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public interface SyConfigMapper 
{
	/**
     * 查询参数配置信息
     * 
     * @param id 参数配置ID
     * @return 参数配置信息
     */
	public SyConfig selectSyConfigById(Integer id);
	
	/**
     * 查询参数配置列表
     * 
     * @param syConfig 参数配置信息
     * @return 参数配置集合
     */
	public List<SyConfig> selectSyConfigList(SyConfig syConfig);
	
	/**
     * 新增参数配置
     * 
     * @param syConfig 参数配置信息
     * @return 结果
     */
	public int insertSyConfig(SyConfig syConfig);
	
	/**
     * 修改参数配置
     * 
     * @param syConfig 参数配置信息
     * @return 结果
     */
	public int updateSyConfig(SyConfig syConfig);
	
	/**
     * 删除参数配置
     * 
     * @param id 参数配置ID
     * @return 结果
     */
	public int deleteSyConfigById(Integer id);
	
	/**
     * 批量删除参数配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyConfigByIds(String[] ids);
	
}