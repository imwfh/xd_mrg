package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 采购订单表 sy_order
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
public class SyOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 订单号 自已平台的 */
	private String orderSn;
	/** 购物车编码 */
	private String cartHashcode;
	/** 支付平台返回的支付号 wx */
	private String prepayId;
	/** 支付平台回调时的订单号 */
	private String tradeNo;
	/** 用户ID */
	private String userCode;
	/** 收货地址id */
	private String addressId;
	/** 物流信息编号 */
	private String logisticCode;
	/** 订单状态 0 支付中 1 待付款 2 待发货 3 已发货 4 已完成 */
	private Integer orderStatus;
	/** 订单附言 */
	private String postscripts;
	/** 商品主题 */
	private String subject;
	/** 商品个数 */
	private Integer goodsCount;
	/** 送货方式编号 */
	private String shippingId;
	/** 支付方式ID  1:支付宝  2:微信  3:个人网银  4:对公网银  5:线下汇款 */
	private String payId;
	/** 商品总金额，原有商品价格的总和，不包含种优惠 */
	private BigDecimal goodsAmount;
	/** 订单总金额 等于商品总额（无论是否被优惠）+邮费 */
	private BigDecimal orderAmount;
	/** 被优惠的金额 商品总金额-订单总金额,即参与活动后的金额有多少 */
	private BigDecimal diusAmount;
	/** 退款状态 0:未发生退款 1:退款成功 2:退款关闭 */
	private Integer refundStatus;
	/** 下单时间 */
	private Date orderTime;
	/** 退款订单号 */
	private String refundNo;
	/** 0:商品购买  1:用户充值 */
	private Integer orderType;
	/** 0:未能返佣 1：成功返佣 */
	private Integer returnFlag;
	/** 实际支付时间 */
	private Date orderPayTime;
	/**  */
	private Integer version;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setOrderSn(String orderSn) 
	{
		this.orderSn = orderSn;
	}

	public String getOrderSn() 
	{
		return orderSn;
	}
	public void setCartHashcode(String cartHashcode) 
	{
		this.cartHashcode = cartHashcode;
	}

	public String getCartHashcode() 
	{
		return cartHashcode;
	}
	public void setPrepayId(String prepayId) 
	{
		this.prepayId = prepayId;
	}

	public String getPrepayId() 
	{
		return prepayId;
	}
	public void setTradeNo(String tradeNo) 
	{
		this.tradeNo = tradeNo;
	}

	public String getTradeNo() 
	{
		return tradeNo;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setAddressId(String addressId) 
	{
		this.addressId = addressId;
	}

	public String getAddressId() 
	{
		return addressId;
	}
	public void setLogisticCode(String logisticCode) 
	{
		this.logisticCode = logisticCode;
	}

	public String getLogisticCode() 
	{
		return logisticCode;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}
	public void setPostscripts(String postscripts) 
	{
		this.postscripts = postscripts;
	}

	public String getPostscripts() 
	{
		return postscripts;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	public void setGoodsCount(Integer goodsCount) 
	{
		this.goodsCount = goodsCount;
	}

	public Integer getGoodsCount() 
	{
		return goodsCount;
	}
	public void setShippingId(String shippingId) 
	{
		this.shippingId = shippingId;
	}

	public String getShippingId() 
	{
		return shippingId;
	}
	public void setPayId(String payId) 
	{
		this.payId = payId;
	}

	public String getPayId() 
	{
		return payId;
	}
	public void setGoodsAmount(BigDecimal goodsAmount) 
	{
		this.goodsAmount = goodsAmount;
	}

	public BigDecimal getGoodsAmount() 
	{
		return goodsAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) 
	{
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderAmount() 
	{
		return orderAmount;
	}
	public void setDiusAmount(BigDecimal diusAmount) 
	{
		this.diusAmount = diusAmount;
	}

	public BigDecimal getDiusAmount() 
	{
		return diusAmount;
	}
	public void setRefundStatus(Integer refundStatus) 
	{
		this.refundStatus = refundStatus;
	}

	public Integer getRefundStatus() 
	{
		return refundStatus;
	}
	public void setOrderTime(Date orderTime) 
	{
		this.orderTime = orderTime;
	}

	public Date getOrderTime() 
	{
		return orderTime;
	}
	public void setRefundNo(String refundNo) 
	{
		this.refundNo = refundNo;
	}

	public String getRefundNo() 
	{
		return refundNo;
	}
	public void setOrderType(Integer orderType) 
	{
		this.orderType = orderType;
	}

	public Integer getOrderType() 
	{
		return orderType;
	}
	public void setReturnFlag(Integer returnFlag) 
	{
		this.returnFlag = returnFlag;
	}

	public Integer getReturnFlag() 
	{
		return returnFlag;
	}
	public void setOrderPayTime(Date orderPayTime) 
	{
		this.orderPayTime = orderPayTime;
	}

	public Date getOrderPayTime() 
	{
		return orderPayTime;
	}
	public void setVersion(Integer version) 
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderSn", getOrderSn())
            .append("cartHashcode", getCartHashcode())
            .append("prepayId", getPrepayId())
            .append("tradeNo", getTradeNo())
            .append("userCode", getUserCode())
            .append("addressId", getAddressId())
            .append("logisticCode", getLogisticCode())
            .append("orderStatus", getOrderStatus())
            .append("postscripts", getPostscripts())
            .append("subject", getSubject())
            .append("goodsCount", getGoodsCount())
            .append("shippingId", getShippingId())
            .append("payId", getPayId())
            .append("goodsAmount", getGoodsAmount())
            .append("orderAmount", getOrderAmount())
            .append("diusAmount", getDiusAmount())
            .append("refundStatus", getRefundStatus())
            .append("orderTime", getOrderTime())
            .append("refundNo", getRefundNo())
            .append("orderType", getOrderType())
            .append("returnFlag", getReturnFlag())
            .append("orderPayTime", getOrderPayTime())
            .append("version", getVersion())
            .toString();
    }
}
