package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SyFeeRate;
import com.ruoyi.system.mapper.SyFeeRateMapper;
import com.ruoyi.system.service.ISyFeeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收益比率 服务层实现
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class SyFeeRateServiceImpl implements ISyFeeRateService 
{
	@Autowired
	private SyFeeRateMapper syFeeRateMapper;

	/**
     * 查询收益比率信息
     * 
     * @param id 收益比率ID
     * @return 收益比率信息
     */
    @Override
	public SyFeeRate selectSyFeeRateById(Integer id)
	{
	    return syFeeRateMapper.selectSyFeeRateById(id);
	}
	
	/**
     * 查询收益比率列表
     * 
     * @param syFeeRate 收益比率信息
     * @return 收益比率集合
     */
	@Override
	public List<SyFeeRate> selectSyFeeRateList(SyFeeRate syFeeRate)
	{
	    return syFeeRateMapper.selectSyFeeRateList(syFeeRate);
	}
	
    /**
     * 新增收益比率
     * 
     * @param syFeeRate 收益比率信息
     * @return 结果
     */
	@Override
	public int insertSyFeeRate(SyFeeRate syFeeRate)
	{
	    return syFeeRateMapper.insertSyFeeRate(syFeeRate);
	}
	
	/**
     * 修改收益比率
     * 
     * @param syFeeRate 收益比率信息
     * @return 结果
     */
	@Override
	public int updateSyFeeRate(SyFeeRate syFeeRate)
	{
	    return syFeeRateMapper.updateSyFeeRate(syFeeRate);
	}

	/**
     * 删除收益比率对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSyFeeRateByIds(String ids)
	{
		return syFeeRateMapper.deleteSyFeeRateByIds(Convert.toStrArray(ids));
	}
	
}
