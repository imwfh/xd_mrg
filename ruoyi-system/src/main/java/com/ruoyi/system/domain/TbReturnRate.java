package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 用户费率表 tb_return_rate
 * 
 * @author ruoyi
 * @date 2019-08-06
 */
public class TbReturnRate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 用户编码 */
	private String userCode;
	/** 所对应下单动作用户的编码 */
	private String parentCode;
	/** 所对应的费率 */
	private BigDecimal rate;
	/** 0:正常  -1:关闭 */
	private Integer rStatus;

	private String parentName;

	private String userName;

	public Integer getrStatus() {
		return rStatus;
	}

	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId() 
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
	public void setParentCode(String parentCode) 
	{
		this.parentCode = parentCode;
	}

	public String getParentCode() 
	{
		return parentCode;
	}
	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getRate()
	{
		return rate;
	}
	public void setRStatus(Integer rStatus) 
	{
		this.rStatus = rStatus;
	}

	public Integer getRStatus() 
	{
		return rStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userCode", getUserCode())
            .append("parentCode", getParentCode())
            .append("rate", getRate())
            .append("createTime", getCreateTime())
            .append("rStatus", getRStatus())
            .toString();
    }
}
