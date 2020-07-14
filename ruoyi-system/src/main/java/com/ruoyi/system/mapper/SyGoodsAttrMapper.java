package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SyGoodsAttr;
import java.util.List;	

/**
 * 商品属性 数据层
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public interface SyGoodsAttrMapper 
{
	/**
     * 查询商品属性信息
     * 
     * @param id 商品属性ID
     * @return 商品属性信息
     */
	public SyGoodsAttr selectSyGoodsAttrById(Integer id);
	
	/**
     * 查询商品属性列表
     * 
     * @param syGoodsAttr 商品属性信息
     * @return 商品属性集合
     */
	public List<SyGoodsAttr> selectSyGoodsAttrList(SyGoodsAttr syGoodsAttr);
	
	/**
     * 新增商品属性
     * 
     * @param syGoodsAttr 商品属性信息
     * @return 结果
     */
	public int insertSyGoodsAttr(SyGoodsAttr syGoodsAttr);
	
	/**
     * 修改商品属性
     * 
     * @param syGoodsAttr 商品属性信息
     * @return 结果
     */
	public int updateSyGoodsAttr(SyGoodsAttr syGoodsAttr);
	
	/**
     * 删除商品属性
     * 
     * @param id 商品属性ID
     * @return 结果
     */
	public int deleteSyGoodsAttrById(Integer id);
	
	/**
     * 批量删除商品属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyGoodsAttrByIds(String[] ids);

	SyGoodsAttr selectSyGoodsAttrByGoodsSn(String goodsSn);
}