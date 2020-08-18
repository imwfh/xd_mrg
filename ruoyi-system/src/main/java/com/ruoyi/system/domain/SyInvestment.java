package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户投资表 sy_investment
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public class SyInvestment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 投资商品名称 */
	private String investmentName;
	/** 投资记录编码 */
	private String investmentCode;
	/** 商品编码 */
	private String investmentTradeCode;
	/** 投资商品金额 */
	private Float investmentMoney;
	/** 投资人编码 */
	private String userCode;
	private String userName;
	/** 0:待平台确认 1:平台已确认(已收账) */
	private Integer platformComfirm;
	/** 0:正常 -1:订单已超时 */
	private Integer isOvertime;
	/** 投资人投资账号BTC */
	private String btcCode;

	/**
	 * 收款账号
	 */
	private String platBtcCode;

	/**
	 * 失败时候的描述
	 */
	private String failDesc;
	/** 投资时间 */
	private Date investmentTime;
	/** 订单过期时间 */
	private Date overTime;
	/** 投资平台确认时间 */
	private Date comfirmTime;

	private Double totalMoney;

	/**
	 * 当前充值汇率
	 */
	private BigDecimal investmentRate;

	/**
	 * 转换成RMB数
	 */
	private BigDecimal revertMoney;

	/**
	 * 凭证
	 */
	private String tkUrl;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getInvestmentRate() {
		return investmentRate;
	}

	public void setInvestmentRate(BigDecimal investmentRate) {
		this.investmentRate = investmentRate;
	}

	public BigDecimal getRevertMoney() {
		return revertMoney;
	}

	public void setRevertMoney(BigDecimal revertMoney) {
		this.revertMoney = revertMoney;
	}

	public String getTkUrl() {
		return tkUrl;
	}

	public void setTkUrl(String tkUrl) {
		this.tkUrl = tkUrl;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getPlatBtcCode() {
		return platBtcCode;
	}

	public void setPlatBtcCode(String platBtcCode) {
		this.platBtcCode = platBtcCode;
	}

	public String getFailDesc() {
		return failDesc;
	}

	public void setFailDesc(String failDesc) {
		this.failDesc = failDesc;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setInvestmentName(String investmentName) 
	{
		this.investmentName = investmentName;
	}

	public String getInvestmentName() 
	{
		return investmentName;
	}
	public void setInvestmentCode(String investmentCode) 
	{
		this.investmentCode = investmentCode;
	}

	public String getInvestmentCode() 
	{
		return investmentCode;
	}
	public void setInvestmentTradeCode(String investmentTradeCode) 
	{
		this.investmentTradeCode = investmentTradeCode;
	}

	public String getInvestmentTradeCode() 
	{
		return investmentTradeCode;
	}
	public void setInvestmentMoney(Float investmentMoney) 
	{
		this.investmentMoney = investmentMoney;
	}

	public Float getInvestmentMoney() 
	{
		return investmentMoney;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setPlatformComfirm(Integer platformComfirm) 
	{
		this.platformComfirm = platformComfirm;
	}

	public Integer getPlatformComfirm() 
	{
		return platformComfirm;
	}
	public void setIsOvertime(Integer isOvertime) 
	{
		this.isOvertime = isOvertime;
	}

	public Integer getIsOvertime() 
	{
		return isOvertime;
	}
	public void setBtcCode(String btcCode) 
	{
		this.btcCode = btcCode;
	}

	public String getBtcCode() 
	{
		return btcCode;
	}
	public void setInvestmentTime(Date investmentTime) 
	{
		this.investmentTime = investmentTime;
	}

	public Date getInvestmentTime() 
	{
		return investmentTime;
	}
	public void setOverTime(Date overTime) 
	{
		this.overTime = overTime;
	}

	public Date getOverTime() 
	{
		return overTime;
	}
	public void setComfirmTime(Date comfirmTime) 
	{
		this.comfirmTime = comfirmTime;
	}

	public Date getComfirmTime() 
	{
		return comfirmTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("investmentName", getInvestmentName())
            .append("investmentCode", getInvestmentCode())
            .append("investmentTradeCode", getInvestmentTradeCode())
            .append("investmentMoney", getInvestmentMoney())
            .append("userCode", getUserCode())
            .append("platformComfirm", getPlatformComfirm())
            .append("isOvertime", getIsOvertime())
            .append("btcCode", getBtcCode())
            .append("investmentTime", getInvestmentTime())
            .append("overTime", getOverTime())
            .append("comfirmTime", getComfirmTime())
            .toString();
    }
}
