package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 火币用户下单表 hb_order_info
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public class HbOrderInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 用户唯一编码 */
	private String userCode;
	/** HB account id */
	private String accountId;
	/** 订单号 自已平台的 */
	private String orderSn;
	/**  */
	private String hbSn;
	/** 下单的交易对 */
	private String symbol;
	/**  */
	private String inUsdt;
	/** 下单总金额 */
	private String price;
	/** 止损价格 */
	private String stopPrice;
	/** 下单数量 */
	private String amount;
	/** 火币已成交数量(买入的是哪个B种数量) */
	private String hbAmount;
	/** 总共花了多少个U买入的当前币种 */
	private String hbTotalPrice;
	/** 火币成交单价(几个U) */
	private String hbPrice;
	/** B成交的手续费 */
	private String hbFieldFees;
	/** 操作类型 */
	private String type;
	/** 0:买入  1:卖出  2:补仓 */
	private Integer orderType;
	/** 0:买入  1:卖出 */
	private Integer orderAction;
	/** 0:未能校对 1：已校对 */
	private Integer orderVerify;
	/** 订单状态 0：支付成功  -1：支付失败 */
	private Integer orderStatus;
	/** 状态描述 */
	private String orderStatusDesc;
	/** 是否被计算 0:否 1:是 */
	private Integer isCal;
	/**  */
	private Integer version;
	/** 购买次数 */
	private Integer orderTimes;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setAccountId(String accountId) 
	{
		this.accountId = accountId;
	}

	public String getAccountId() 
	{
		return accountId;
	}
	public void setOrderSn(String orderSn) 
	{
		this.orderSn = orderSn;
	}

	public String getOrderSn() 
	{
		return orderSn;
	}
	public void setHbSn(String hbSn) 
	{
		this.hbSn = hbSn;
	}

	public String getHbSn() 
	{
		return hbSn;
	}
	public void setSymbol(String symbol) 
	{
		this.symbol = symbol;
	}

	public String getSymbol() 
	{
		return symbol;
	}
	public void setInUsdt(String inUsdt) 
	{
		this.inUsdt = inUsdt;
	}

	public String getInUsdt() 
	{
		return inUsdt;
	}
	public void setPrice(String price) 
	{
		this.price = price;
	}

	public String getPrice() 
	{
		return price;
	}
	public void setStopPrice(String stopPrice) 
	{
		this.stopPrice = stopPrice;
	}

	public String getStopPrice() 
	{
		return stopPrice;
	}
	public void setAmount(String amount) 
	{
		this.amount = amount;
	}

	public String getAmount() 
	{
		return amount;
	}
	public void setHbAmount(String hbAmount) 
	{
		this.hbAmount = hbAmount;
	}

	public String getHbAmount() 
	{
		return hbAmount;
	}
	public void setHbTotalPrice(String hbTotalPrice) 
	{
		this.hbTotalPrice = hbTotalPrice;
	}

	public String getHbTotalPrice() 
	{
		return hbTotalPrice;
	}
	public void setHbPrice(String hbPrice) 
	{
		this.hbPrice = hbPrice;
	}

	public String getHbPrice() 
	{
		return hbPrice;
	}
	public void setHbFieldFees(String hbFieldFees) 
	{
		this.hbFieldFees = hbFieldFees;
	}

	public String getHbFieldFees() 
	{
		return hbFieldFees;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setOrderType(Integer orderType) 
	{
		this.orderType = orderType;
	}

	public Integer getOrderType() 
	{
		return orderType;
	}
	public void setOrderAction(Integer orderAction) 
	{
		this.orderAction = orderAction;
	}

	public Integer getOrderAction() 
	{
		return orderAction;
	}
	public void setOrderVerify(Integer orderVerify) 
	{
		this.orderVerify = orderVerify;
	}

	public Integer getOrderVerify() 
	{
		return orderVerify;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}
	public void setOrderStatusDesc(String orderStatusDesc) 
	{
		this.orderStatusDesc = orderStatusDesc;
	}

	public String getOrderStatusDesc() 
	{
		return orderStatusDesc;
	}
	public void setIsCal(Integer isCal) 
	{
		this.isCal = isCal;
	}

	public Integer getIsCal() 
	{
		return isCal;
	}
	public void setVersion(Integer version) 
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	public void setOrderTimes(Integer orderTimes) 
	{
		this.orderTimes = orderTimes;
	}

	public Integer getOrderTimes() 
	{
		return orderTimes;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userCode", getUserCode())
            .append("accountId", getAccountId())
            .append("orderSn", getOrderSn())
            .append("hbSn", getHbSn())
            .append("symbol", getSymbol())
            .append("inUsdt", getInUsdt())
            .append("price", getPrice())
            .append("stopPrice", getStopPrice())
            .append("amount", getAmount())
            .append("hbAmount", getHbAmount())
            .append("hbTotalPrice", getHbTotalPrice())
            .append("hbPrice", getHbPrice())
            .append("hbFieldFees", getHbFieldFees())
            .append("type", getType())
            .append("orderType", getOrderType())
            .append("orderAction", getOrderAction())
            .append("orderVerify", getOrderVerify())
            .append("orderStatus", getOrderStatus())
            .append("orderStatusDesc", getOrderStatusDesc())
            .append("isCal", getIsCal())
            .append("createTime", getCreateTime())
            .append("version", getVersion())
            .append("orderTimes", getOrderTimes())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
