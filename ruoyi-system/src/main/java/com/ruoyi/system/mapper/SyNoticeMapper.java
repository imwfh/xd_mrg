package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyNotice;
import java.util.List;	

/**
 * 公告 数据层
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public interface SyNoticeMapper 
{
	/**
     * 查询公告信息
     * 
     * @param id 公告ID
     * @return 公告信息
     */
	public SyNotice selectSyNoticeById(Integer id);

	public List<SyNotice> selectSyNoticeByHashCode(String hashCode);
	
	/**
     * 查询公告列表
     * 
     * @param syNotice 公告信息
     * @return 公告集合
     */
	public List<SyNotice> selectSyNoticeList(SyNotice syNotice);
	
	/**
     * 新增公告
     * 
     * @param syNotice 公告信息
     * @return 结果
     */
	public int insertSyNotice(SyNotice syNotice);
	
	/**
     * 修改公告
     * 
     * @param syNotice 公告信息
     * @return 结果
     */
	public int updateSyNotice(SyNotice syNotice);
	
	/**
     * 删除公告
     * 
     * @param id 公告ID
     * @return 结果
     */
	public int deleteSyNoticeById(Integer id);
	
	/**
     * 批量删除公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyNoticeByIds(String[] ids);
	
}