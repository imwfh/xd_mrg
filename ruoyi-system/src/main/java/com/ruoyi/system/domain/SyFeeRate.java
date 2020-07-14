package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收益比率表 sy_fee_rate
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public class SyFeeRate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 费率对应的人数 */
	private Integer rateNumber;
	/** 一代对应的费率 */
	private Float rateFee;
	/** 达到指定人数后，团队长(团队管理奖)对应的费率 */
	private Float rateGroup;
	/** 达到指定人数后，团队长拿平台利润比 */
	private Float ratePlatform;
	/** 表静态收益率 */
	private Float rateStaticFee;
	/** 1:日类型 2:月类型 */
	private Integer rateStaticType;
	/** 1:动态收益率 2:静态收益率 */
	private Integer rateType;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setRateNumber(Integer rateNumber) 
	{
		this.rateNumber = rateNumber;
	}

	public Integer getRateNumber() 
	{
		return rateNumber;
	}
	public void setRateFee(Float rateFee) 
	{
		this.rateFee = rateFee;
	}

	public Float getRateFee() 
	{
		return rateFee;
	}
	public void setRateGroup(Float rateGroup) 
	{
		this.rateGroup = rateGroup;
	}

	public Float getRateGroup() 
	{
		return rateGroup;
	}
	public void setRatePlatform(Float ratePlatform) 
	{
		this.ratePlatform = ratePlatform;
	}

	public Float getRatePlatform() 
	{
		return ratePlatform;
	}
	public void setRateStaticFee(Float rateStaticFee) 
	{
		this.rateStaticFee = rateStaticFee;
	}

	public Float getRateStaticFee() 
	{
		return rateStaticFee;
	}
	public void setRateStaticType(Integer rateStaticType) 
	{
		this.rateStaticType = rateStaticType;
	}

	public Integer getRateStaticType() 
	{
		return rateStaticType;
	}
	public void setRateType(Integer rateType) 
	{
		this.rateType = rateType;
	}

	public Integer getRateType() 
	{
		return rateType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rateNumber", getRateNumber())
            .append("rateFee", getRateFee())
            .append("rateGroup", getRateGroup())
            .append("ratePlatform", getRatePlatform())
            .append("rateStaticFee", getRateStaticFee())
            .append("rateStaticType", getRateStaticType())
            .append("rateType", getRateType())
            .toString();
    }
}
