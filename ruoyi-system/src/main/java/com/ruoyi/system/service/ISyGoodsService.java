package com.ruoyi.system.service;

import com.ruoyi.system.domain.SyGoods;
import java.util.List;

/**
 * 商品 服务层
 * 
 * @author ruoyi
 * @date 2019-07-29
 */
public interface ISyGoodsService 
{
	/**
     * 查询商品信息
     * 
     * @param id 商品ID
     * @return 商品信息
     */
	public SyGoods selectSyGoodsById(Integer id);
	
	/**
     * 查询商品列表
     * 
     * @param syGoods 商品信息
     * @return 商品集合
     */
	public List<SyGoods> selectSyGoodsList(SyGoods syGoods);
	
	/**
     * 新增商品
     * 
     * @param syGoods 商品信息
     * @return 结果
     */
	public int insertSyGoods(SyGoods syGoods);
	
	/**
     * 修改商品
     * 
     * @param syGoods 商品信息
     * @return 结果
     */
	public int updateSyGoods(SyGoods syGoods);
		
	/**
     * 删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSyGoodsByIds(String ids);
	
}
