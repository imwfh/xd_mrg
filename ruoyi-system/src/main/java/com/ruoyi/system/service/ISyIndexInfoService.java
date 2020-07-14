package com.ruoyi.system.service;

import com.ruoyi.system.domain.SyIndexInfo;
import java.util.List;

/**
 * 首页轮播图 服务层
 * 
 * @author ruoyi
 * @date 2019-08-07
 */
public interface ISyIndexInfoService 
{
	/**
     * 查询首页轮播图信息
     * 
     * @param id 首页轮播图ID
     * @return 首页轮播图信息
     */
	public SyIndexInfo selectSyIndexInfoById(Integer id);
	
	/**
     * 查询首页轮播图列表
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 首页轮播图集合
     */
	public List<SyIndexInfo> selectSyIndexInfoList(SyIndexInfo syIndexInfo);
	
	/**
     * 新增首页轮播图
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 结果
     */
	public int insertSyIndexInfo(SyIndexInfo syIndexInfo);
	
	/**
     * 修改首页轮播图
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 结果
     */
	public int updateSyIndexInfo(SyIndexInfo syIndexInfo);
		
	/**
     * 删除首页轮播图信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyIndexInfoByIds(String ids);
	
}
