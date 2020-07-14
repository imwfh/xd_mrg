package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyGameConfig;
import java.util.List;	

/**
 * 游戏配置 数据层
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public interface SyGameConfigMapper 
{
	/**
     * 查询游戏配置信息
     * 
     * @param id 游戏配置ID
     * @return 游戏配置信息
     */
	public SyGameConfig selectSyGameConfigById(Integer id);
	
	/**
     * 查询游戏配置列表
     * 
     * @param syGameConfig 游戏配置信息
     * @return 游戏配置集合
     */
	public List<SyGameConfig> selectSyGameConfigList(SyGameConfig syGameConfig);
	
	/**
     * 新增游戏配置
     * 
     * @param syGameConfig 游戏配置信息
     * @return 结果
     */
	public int insertSyGameConfig(SyGameConfig syGameConfig);
	
	/**
     * 修改游戏配置
     * 
     * @param syGameConfig 游戏配置信息
     * @return 结果
     */
	public int updateSyGameConfig(SyGameConfig syGameConfig);
	
	/**
     * 删除游戏配置
     * 
     * @param id 游戏配置ID
     * @return 结果
     */
	public int deleteSyGameConfigById(Integer id);
	
	/**
     * 批量删除游戏配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyGameConfigByIds(String[] ids);
	
}