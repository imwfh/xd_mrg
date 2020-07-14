package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyIndexInfo;
import com.ruoyi.system.mapper.SyIndexInfoMapper;
import com.ruoyi.system.service.ISyIndexInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页轮播图 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-07
 */
@Service
public class SyIndexInfoServiceImpl implements ISyIndexInfoService 
{
	@Autowired
	private SyIndexInfoMapper syIndexInfoMapper;

	/**
     * 查询首页轮播图信息
     * 
     * @param id 首页轮播图ID
     * @return 首页轮播图信息
     */
    @Override
	public SyIndexInfo selectSyIndexInfoById(Integer id)
	{
	    return syIndexInfoMapper.selectSyIndexInfoById(id);
	}
	
	/**
     * 查询首页轮播图列表
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 首页轮播图集合
     */
	@Override
	public List<SyIndexInfo> selectSyIndexInfoList(SyIndexInfo syIndexInfo)
	{
	    return syIndexInfoMapper.selectSyIndexInfoList(syIndexInfo);
	}
	
    /**
     * 新增首页轮播图
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 结果
     */
	@Override
	public int insertSyIndexInfo(SyIndexInfo syIndexInfo)
	{
	    return syIndexInfoMapper.insertSyIndexInfo(syIndexInfo);
	}
	
	/**
     * 修改首页轮播图
     * 
     * @param syIndexInfo 首页轮播图信息
     * @return 结果
     */
	@Override
	public int updateSyIndexInfo(SyIndexInfo syIndexInfo)
	{
	    return syIndexInfoMapper.updateSyIndexInfo(syIndexInfo);
	}

	/**
     * 删除首页轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyIndexInfoByIds(String ids)
	{
		return syIndexInfoMapper.deleteSyIndexInfoByIds(Convert.toStrArray(ids));
	}
	
}
