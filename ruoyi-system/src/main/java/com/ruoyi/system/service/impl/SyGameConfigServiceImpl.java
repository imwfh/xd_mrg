package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyGameConfig;
import com.ruoyi.system.mapper.SyGameConfigMapper;
import com.ruoyi.system.service.ISyGameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 游戏配置 服务层实现
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
@Service
public class SyGameConfigServiceImpl implements ISyGameConfigService 
{
	@Autowired
	private SyGameConfigMapper syGameConfigMapper;

	/**
     * 查询游戏配置信息
     * 
     * @param id 游戏配置ID
     * @return 游戏配置信息
     */
    @Override
	public SyGameConfig selectSyGameConfigById(Integer id)
	{
	    return syGameConfigMapper.selectSyGameConfigById(id);
	}
	
	/**
     * 查询游戏配置列表
     * 
     * @param syGameConfig 游戏配置信息
     * @return 游戏配置集合
     */
	@Override
	public List<SyGameConfig> selectSyGameConfigList(SyGameConfig syGameConfig)
	{
	    return syGameConfigMapper.selectSyGameConfigList(syGameConfig);
	}
	
    /**
     * 新增游戏配置
     * 
     * @param syGameConfig 游戏配置信息
     * @return 结果
     */
	@Override
	public int insertSyGameConfig(SyGameConfig syGameConfig)
	{
	    return syGameConfigMapper.insertSyGameConfig(syGameConfig);
	}
	
	/**
     * 修改游戏配置
     * 
     * @param syGameConfig 游戏配置信息
     * @return 结果
     */
	@Override
	public int updateSyGameConfig(SyGameConfig syGameConfig)
	{
	    return syGameConfigMapper.updateSyGameConfig(syGameConfig);
	}

	/**
     * 删除游戏配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyGameConfigByIds(String ids)
	{
		return syGameConfigMapper.deleteSyGameConfigByIds(Convert.toStrArray(ids));
	}
	
}
