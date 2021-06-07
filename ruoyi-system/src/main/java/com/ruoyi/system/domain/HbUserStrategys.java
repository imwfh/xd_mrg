package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 火币用户策略集表 hb_user_strategys
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public class HbUserStrategys extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 用户唯一编码 */
	private String userCode;
	/** 交易对名称 */
	private String symbolName;
	/** 策略编码 */
	private String strategyNo;
	/** 首投金额 */
	private Float firstMoney;
	/** 做单数量 */
	private Integer orderNumber;
	/** 止盈比例 */
	private Float profitStopRate;
	/** 止盈回调比例 */
	private Float profitBackRate;
	/** 补仓比例，用|分割  0.02|0.05 */
	private String buyInRate;
	/** 补仓回调比例 */
	private Float buyInBackRate;
	/** 0:未启动 1:已启动 -1:已暂停 */
	private Integer status;
	/** 策略类型  0 = 单次策略 1 = 循环策略 */
	private Integer strategyType;

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
	public void setSymbolName(String symbolName) 
	{
		this.symbolName = symbolName;
	}

	public String getSymbolName() 
	{
		return symbolName;
	}
	public void setStrategyNo(String strategyNo) 
	{
		this.strategyNo = strategyNo;
	}

	public String getStrategyNo() 
	{
		return strategyNo;
	}
	public void setFirstMoney(Float firstMoney) 
	{
		this.firstMoney = firstMoney;
	}

	public Float getFirstMoney() 
	{
		return firstMoney;
	}
	public void setOrderNumber(Integer orderNumber) 
	{
		this.orderNumber = orderNumber;
	}

	public Integer getOrderNumber() 
	{
		return orderNumber;
	}
	public void setProfitStopRate(Float profitStopRate) 
	{
		this.profitStopRate = profitStopRate;
	}

	public Float getProfitStopRate() 
	{
		return profitStopRate;
	}
	public void setProfitBackRate(Float profitBackRate) 
	{
		this.profitBackRate = profitBackRate;
	}

	public Float getProfitBackRate() 
	{
		return profitBackRate;
	}
	public void setBuyInRate(String buyInRate) 
	{
		this.buyInRate = buyInRate;
	}

	public String getBuyInRate() 
	{
		return buyInRate;
	}
	public void setBuyInBackRate(Float buyInBackRate) 
	{
		this.buyInBackRate = buyInBackRate;
	}

	public Float getBuyInBackRate() 
	{
		return buyInBackRate;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setStrategyType(Integer strategyType) 
	{
		this.strategyType = strategyType;
	}

	public Integer getStrategyType() 
	{
		return strategyType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userCode", getUserCode())
            .append("symbolName", getSymbolName())
            .append("strategyNo", getStrategyNo())
            .append("firstMoney", getFirstMoney())
            .append("orderNumber", getOrderNumber())
            .append("profitStopRate", getProfitStopRate())
            .append("profitBackRate", getProfitBackRate())
            .append("buyInRate", getBuyInRate())
            .append("buyInBackRate", getBuyInBackRate())
            .append("status", getStatus())
            .append("strategyType", getStrategyType())
            .append("createTime", getCreateTime())
            .toString();
    }
}
