package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TbReturnRate;
import com.ruoyi.system.mapper.TbReturnRateMapper;
import com.ruoyi.system.service.ITbReturnRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户费率 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
@Service
public class TbReturnRateServiceImpl implements ITbReturnRateService 
{
	@Autowired
	private TbReturnRateMapper tbReturnRateMapper;

	/**
     * 查询用户费率信息
     * 
     * @param id 用户费率ID
     * @return 用户费率信息
     */
    @Override
	public TbReturnRate selectTbReturnRateById(Long id)
	{
	    return tbReturnRateMapper.selectTbReturnRateById(id);
	}
	
	/**
     * 查询用户费率列表
     * 
     * @param tbReturnRate 用户费率信息
     * @return 用户费率集合
     */
	@Override
	public List<TbReturnRate> selectTbReturnRateList(TbReturnRate tbReturnRate)
	{
	    return tbReturnRateMapper.selectTbReturnRateList(tbReturnRate);
	}
	
    /**
     * 新增用户费率
     * 
     * @param tbReturnRate 用户费率信息
     * @return 结果
     */
	@Override
	public int insertTbReturnRate(TbReturnRate tbReturnRate)
	{
	    return tbReturnRateMapper.insertTbReturnRate(tbReturnRate);
	}
	
	/**
     * 修改用户费率
     * 
     * @param tbReturnRate 用户费率信息
     * @return 结果
     */
	@Override
	public int updateTbReturnRate(TbReturnRate tbReturnRate)
	{
	    return tbReturnRateMapper.updateTbReturnRate(tbReturnRate);
	}

	/**
     * 删除用户费率对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbReturnRateByIds(String ids)
	{
		return tbReturnRateMapper.deleteTbReturnRateByIds(Convert.toStrArray(ids));
	}
	
}
