package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TbUserTx;
import com.ruoyi.system.mapper.TbUserTxMapper;
import com.ruoyi.system.service.ITbUserTxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 提现记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
@Service
public class TbUserTxServiceImpl implements ITbUserTxService 
{
	@Autowired
	private TbUserTxMapper tbUserTxMapper;

	/**
     * 查询提现记录信息
     * 
     * @param id 提现记录ID
     * @return 提现记录信息
     */
    @Override
	public TbUserTx selectTbUserTxById(Long id)
	{
	    return tbUserTxMapper.selectTbUserTxById(id);
	}
	
	/**
     * 查询提现记录列表
     * 
     * @param tbUserTx 提现记录信息
     * @return 提现记录集合
     */
	@Override
	public List<TbUserTx> selectTbUserTxList(TbUserTx tbUserTx)
	{
	    return tbUserTxMapper.selectTbUserTxList(tbUserTx);
	}
	
    /**
     * 新增提现记录
     * 
     * @param tbUserTx 提现记录信息
     * @return 结果
     */
	@Override
	public int insertTbUserTx(TbUserTx tbUserTx)
	{
	    return tbUserTxMapper.insertTbUserTx(tbUserTx);
	}
	
	/**
     * 修改提现记录
     * 
     * @param tbUserTx 提现记录信息
     * @return 结果
     */
	@Override
	public int updateTbUserTx(TbUserTx tbUserTx)
	{
	    return tbUserTxMapper.updateTbUserTx(tbUserTx);
	}

	/**
     * 删除提现记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbUserTxByIds(String ids)
	{
		return tbUserTxMapper.deleteTbUserTxByIds(Convert.toStrArray(ids));
	}
	
}
