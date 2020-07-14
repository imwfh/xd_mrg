package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品属性表 sy_goods_attr
 * 
 * @author ruoyi
 * @date 2019-08-02
 */
public class SyGoodsAttr extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 商品号 */
	private String goodsSn;
	/** 商品总库存 */
	private Integer goodsTotalCount;
	/** 商品剩余库存 */
	private Integer goodsTotalCountSurplus;
	/** 商品总销量 */
	private Integer goodsSalesCount;
	/** 商品介绍详情图片 */
	private String goodsDetailImgs;
	/** 商品质量信息 */
	private String goodsDetailReport;
	/** 商品SKU 规格等  json字符串 */
	private String goodsSku;
	/**  */
	private String goodsPriceSku;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setGoodsSn(String goodsSn) 
	{
		this.goodsSn = goodsSn;
	}

	public String getGoodsSn() 
	{
		return goodsSn;
	}
	public void setGoodsTotalCount(Integer goodsTotalCount) 
	{
		this.goodsTotalCount = goodsTotalCount;
	}

	public Integer getGoodsTotalCount() 
	{
		return goodsTotalCount;
	}
	public void setGoodsTotalCountSurplus(Integer goodsTotalCountSurplus) 
	{
		this.goodsTotalCountSurplus = goodsTotalCountSurplus;
	}

	public Integer getGoodsTotalCountSurplus() 
	{
		return goodsTotalCountSurplus;
	}
	public void setGoodsSalesCount(Integer goodsSalesCount) 
	{
		this.goodsSalesCount = goodsSalesCount;
	}

	public Integer getGoodsSalesCount() 
	{
		return goodsSalesCount;
	}
	public void setGoodsDetailImgs(String goodsDetailImgs) 
	{
		this.goodsDetailImgs = goodsDetailImgs;
	}

	public String getGoodsDetailImgs() 
	{
		return goodsDetailImgs;
	}
	public void setGoodsDetailReport(String goodsDetailReport) 
	{
		this.goodsDetailReport = goodsDetailReport;
	}

	public String getGoodsDetailReport() 
	{
		return goodsDetailReport;
	}
	public void setGoodsSku(String goodsSku) 
	{
		this.goodsSku = goodsSku;
	}

	public String getGoodsSku() 
	{
		return goodsSku;
	}
	public void setGoodsPriceSku(String goodsPriceSku) 
	{
		this.goodsPriceSku = goodsPriceSku;
	}

	public String getGoodsPriceSku() 
	{
		return goodsPriceSku;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsSn", getGoodsSn())
            .append("goodsTotalCount", getGoodsTotalCount())
            .append("goodsTotalCountSurplus", getGoodsTotalCountSurplus())
            .append("goodsSalesCount", getGoodsSalesCount())
            .append("goodsDetailImgs", getGoodsDetailImgs())
            .append("goodsDetailReport", getGoodsDetailReport())
            .append("goodsSku", getGoodsSku())
            .append("goodsPriceSku", getGoodsPriceSku())
            .append("createTime", getCreateTime())
            .toString();
    }
}
