package com.ruoyi.system.service;

import com.ruoyi.system.domain.SyGameRate;
import java.util.List;

/**
 * 用户等级 服务层
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public interface ISyGameRateService 
{
	/**
     * 查询用户等级信息
     * 
     * @param id 用户等级ID
     * @return 用户等级信息
     */
	public SyGameRate selectSyGameRateById(Integer id);
	
	/**
     * 查询用户等级列表
     * 
     * @param syGameRate 用户等级信息
     * @return 用户等级集合
     */
	public List<SyGameRate> selectSyGameRateList(SyGameRate syGameRate);
	
	/**
     * 新增用户等级
     * 
     * @param syGameRate 用户等级信息
     * @return 结果
     */
	public int insertSyGameRate(SyGameRate syGameRate);
	
	/**
     * 修改用户等级
     * 
     * @param syGameRate 用户等级信息
     * @return 结果
     */
	public int updateSyGameRate(SyGameRate syGameRate);
		
	/**
     * 删除用户等级信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyGameRateByIds(String ids);
	
}
