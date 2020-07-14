package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TbReturnRateLog;
import com.ruoyi.system.mapper.TbReturnRateLogMapper;
import com.ruoyi.system.service.ITbReturnRateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户费率日志记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
@Service
public class TbReturnRateLogServiceImpl implements ITbReturnRateLogService 
{
	@Autowired
	private TbReturnRateLogMapper tbReturnRateLogMapper;

	/**
     * 查询用户费率日志记录信息
     * 
     * @param id 用户费率日志记录ID
     * @return 用户费率日志记录信息
     */
	public TbReturnRateLog selectTbReturnRateLogById(Long id)
	{
	    return tbReturnRateLogMapper.selectTbReturnRateLogById(id);
	}
	
	/**
     * 查询用户费率日志记录列表
     * 
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 用户费率日志记录集合
     */
	public List<TbReturnRateLog> selectTbReturnRateLogList(TbReturnRateLog tbReturnRateLog)
	{
	    return tbReturnRateLogMapper.selectTbReturnRateLogList(tbReturnRateLog);
	}
	
    /**
     * 新增用户费率日志记录
     * 
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 结果
     */
	public int insertTbReturnRateLog(TbReturnRateLog tbReturnRateLog)
	{
	    return tbReturnRateLogMapper.insertTbReturnRateLog(tbReturnRateLog);
	}
	
	/**
     * 修改用户费率日志记录
     * 
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 结果
     */
	public int updateTbReturnRateLog(TbReturnRateLog tbReturnRateLog)
	{
	    return tbReturnRateLogMapper.updateTbReturnRateLog(tbReturnRateLog);
	}

	/**
     * 删除用户费率日志记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbReturnRateLogByIds(String ids)
	{
		return tbReturnRateLogMapper.deleteTbReturnRateLogByIds(Convert.toStrArray(ids));
	}
	
}
