package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 用户投资收益表 sy_profit_rec
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public class SyProfitRec extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 收益金额 */
	private Float profitMoney;
	/** 收益记录编码 */
	private String profitCode;
	/** 投资记录编码 */
	private String investmentCode;
	/** 投资人编码 */
	private String userCode;
	/** 来源于哪个用户 */
	private String fromCode;
	/** 收益类型  1:日类型 2:月类型 3:动态收益 4:团队长奖励 5:平台给予奖励 */
	private Integer profitType;
	/** 收益时间，具哪天 */
	private Date profitTime;
	/** 收益计算时间 */
	private Date computerTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setProfitMoney(Float profitMoney) 
	{
		this.profitMoney = profitMoney;
	}

	public Float getProfitMoney() 
	{
		return profitMoney;
	}
	public void setProfitCode(String profitCode) 
	{
		this.profitCode = profitCode;
	}

	public String getProfitCode() 
	{
		return profitCode;
	}
	public void setInvestmentCode(String investmentCode) 
	{
		this.investmentCode = investmentCode;
	}

	public String getInvestmentCode() 
	{
		return investmentCode;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setFromCode(String fromCode) 
	{
		this.fromCode = fromCode;
	}

	public String getFromCode() 
	{
		return fromCode;
	}
	public void setProfitType(Integer profitType) 
	{
		this.profitType = profitType;
	}

	public Integer getProfitType() 
	{
		return profitType;
	}
	public void setProfitTime(Date profitTime) 
	{
		this.profitTime = profitTime;
	}

	public Date getProfitTime() 
	{
		return profitTime;
	}
	public void setComputerTime(Date computerTime) 
	{
		this.computerTime = computerTime;
	}

	public Date getComputerTime() 
	{
		return computerTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("profitMoney", getProfitMoney())
            .append("profitCode", getProfitCode())
            .append("investmentCode", getInvestmentCode())
            .append("userCode", getUserCode())
            .append("fromCode", getFromCode())
            .append("profitType", getProfitType())
            .append("profitTime", getProfitTime())
            .append("computerTime", getComputerTime())
            .toString();
    }
}
