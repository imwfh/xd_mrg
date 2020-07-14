package com.ruoyi.system.service;

import com.ruoyi.system.domain.TbReturnRate;
import java.util.List;

/**
 * 用户费率 服务层
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
public interface ITbReturnRateService 
{
	/**
     * 查询用户费率信息
     * 
     * @param id 用户费率ID
     * @return 用户费率信息
     */
	public TbReturnRate selectTbReturnRateById(Long id);
	
	/**
     * 查询用户费率列表
     * 
     * @param tbReturnRate 用户费率信息
     * @return 用户费率集合
     */
	public List<TbReturnRate> selectTbReturnRateList(TbReturnRate tbReturnRate);
	
	/**
     * 新增用户费率
     * 
     * @param tbReturnRate 用户费率信息
     * @return 结果
     */
	public int insertTbReturnRate(TbReturnRate tbReturnRate);
	
	/**
     * 修改用户费率
     * 
     * @param tbReturnRate 用户费率信息
     * @return 结果
     */
	public int updateTbReturnRate(TbReturnRate tbReturnRate);
		
	/**
     * 删除用户费率信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbReturnRateByIds(String ids);
	
}
