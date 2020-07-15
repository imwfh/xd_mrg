package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账变记录表 sy_trade_rec
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public class SyTradeRec extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 变动金额 */
	private Float tradeMoney;
	/** 记录编码 */
	private String tradeCode;
	/** 人编码 */
	private String userCode;
	/** 变动前余额 */
	private Float moneyFrom;
	/** 变动后余额 */
	private Float moneyTo;
	/** 收益类型   1:本金转金币 2:金币转本金  3:收益转盈利  4:盈利转本金  5:获得中奖  6:获取返佣 */
	private Integer tradeType;
	/** 操作类型   */
	private Integer operaType;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTradeMoney(Float tradeMoney) 
	{
		this.tradeMoney = tradeMoney;
	}

	public Float getTradeMoney() 
	{
		return tradeMoney;
	}
	public void setTradeCode(String tradeCode) 
	{
		this.tradeCode = tradeCode;
	}

	public String getTradeCode() 
	{
		return tradeCode;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setMoneyFrom(Float moneyFrom) 
	{
		this.moneyFrom = moneyFrom;
	}

	public Float getMoneyFrom() 
	{
		return moneyFrom;
	}
	public void setMoneyTo(Float moneyTo) 
	{
		this.moneyTo = moneyTo;
	}

	public Float getMoneyTo() 
	{
		return moneyTo;
	}
	public void setTradeType(Integer tradeType) 
	{
		this.tradeType = tradeType;
	}

	public Integer getTradeType() 
	{
		return tradeType;
	}
	public void setOperaType(Integer operaType) 
	{
		this.operaType = operaType;
	}

	public Integer getOperaType() 
	{
		return operaType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tradeMoney", getTradeMoney())
            .append("tradeCode", getTradeCode())
            .append("userCode", getUserCode())
            .append("moneyFrom", getMoneyFrom())
            .append("moneyTo", getMoneyTo())
            .append("tradeType", getTradeType())
            .append("operaType", getOperaType())
            .append("createTime", getCreateTime())
            .toString();
    }
}
