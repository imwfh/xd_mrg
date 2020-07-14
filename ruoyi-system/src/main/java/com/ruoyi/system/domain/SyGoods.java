package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 商品表 sy_goods
 * 
 * @author ruoyi
 * @date 2019-07-29
 */
public class SyGoods extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 商品号 */
	private String goodsSn;
	/** 商品名称 */
	private String goodsName;
	/** 商品图片地址 */
	private String goodsImg;
	/** 商品小图，用逗号分开 */
	private String goodsSubimg;
	/** 商品价格-零售价格 展示价格 */
	private BigDecimal shopPrice;
	/** 商品状态  0:在售中  -1:下架 */
	private Integer goodsStatus;
	private String goodsStatusStr;
	/** 上架时间 */
	private Date saleTime;
	/** 0:不上架 1:上架 */
	private Integer isSale;
	/** 是否热销产品	0:否 1:是 */
	private Integer isHot;
	private String isHotStr;
	/** 是否新品	0:否 1:是 */
	private Integer isNew;
	private String isNewStr;
	/** 删除标志	-1:删除 1:有效 */
	private Integer dataFlag;

	/**
	 * 是否有属性  1:有  0:没有
	 */
	private int haveAttr;

	public int getHaveAttr() {
		return haveAttr;
	}

	public void setHaveAttr(int haveAttr) {
		this.haveAttr = haveAttr;
	}

	public String getIsHotStr() {
		return isHotStr;
	}

	public void setIsHotStr(String isHotStr) {
		this.isHotStr = isHotStr;
	}

	public String getIsNewStr() {
		return isNewStr;
	}

	public void setIsNewStr(String isNewStr) {
		this.isNewStr = isNewStr;
	}

	public String getGoodsStatusStr() {
		return goodsStatusStr;
	}

	public void setGoodsStatusStr(String goodsStatusStr) {
		this.goodsStatusStr = goodsStatusStr;
	}

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
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setGoodsImg(String goodsImg) 
	{
		this.goodsImg = goodsImg;
	}

	public String getGoodsImg() 
	{
		return goodsImg;
	}
	public void setGoodsSubimg(String goodsSubimg) 
	{
		this.goodsSubimg = goodsSubimg;
	}

	public String getGoodsSubimg() 
	{
		return goodsSubimg;
	}
	public void setShopPrice(BigDecimal shopPrice)
	{
		this.shopPrice = shopPrice;
	}

	public BigDecimal getShopPrice()
	{
		return shopPrice;
	}
	public void setGoodsStatus(Integer goodsStatus) 
	{
		this.goodsStatus = goodsStatus;
	}

	public Integer getGoodsStatus() 
	{
		return goodsStatus;
	}
	public void setSaleTime(Date saleTime) 
	{
		this.saleTime = saleTime;
	}

	public Date getSaleTime() 
	{
		return saleTime;
	}
	public void setIsSale(Integer isSale) 
	{
		this.isSale = isSale;
	}

	public Integer getIsSale() 
	{
		return isSale;
	}
	public void setIsHot(Integer isHot) 
	{
		this.isHot = isHot;
	}

	public Integer getIsHot() 
	{
		return isHot;
	}
	public void setIsNew(Integer isNew) 
	{
		this.isNew = isNew;
	}

	public Integer getIsNew() 
	{
		return isNew;
	}
	public void setDataFlag(Integer dataFlag) 
	{
		this.dataFlag = dataFlag;
	}

	public Integer getDataFlag() 
	{
		return dataFlag;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsSn", getGoodsSn())
            .append("goodsName", getGoodsName())
            .append("goodsImg", getGoodsImg())
            .append("goodsSubimg", getGoodsSubimg())
            .append("shopPrice", getShopPrice())
            .append("goodsStatus", getGoodsStatus())
            .append("createTime", getCreateTime())
            .append("saleTime", getSaleTime())
            .append("isSale", getIsSale())
            .append("isHot", getIsHot())
            .append("isNew", getIsNew())
            .append("dataFlag", getDataFlag())
            .toString();
    }
}
