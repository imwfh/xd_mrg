package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 平台收款账户表 sy_rev_account
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public class SyRevAccount extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 收款账号 */
	private String revAccount;
	/** 收款账号对应的姓名 */
	private String revName;
	/** 手机号 */
	private String revPhone;
	/** 0:正常 -1:已关闭 */
	private Integer revStatus;
	/** 权重值 */
	private Float revWeight;
	/** 入库时间 */
	private Date revTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setRevAccount(String revAccount) 
	{
		this.revAccount = revAccount;
	}

	public String getRevAccount() 
	{
		return revAccount;
	}
	public void setRevName(String revName) 
	{
		this.revName = revName;
	}

	public String getRevName() 
	{
		return revName;
	}
	public void setRevPhone(String revPhone) 
	{
		this.revPhone = revPhone;
	}

	public String getRevPhone() 
	{
		return revPhone;
	}
	public void setRevStatus(Integer revStatus) 
	{
		this.revStatus = revStatus;
	}

	public Integer getRevStatus() 
	{
		return revStatus;
	}
	public void setRevWeight(Float revWeight) 
	{
		this.revWeight = revWeight;
	}

	public Float getRevWeight() 
	{
		return revWeight;
	}
	public void setRevTime(Date revTime) 
	{
		this.revTime = revTime;
	}

	public Date getRevTime() 
	{
		return revTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("revAccount", getRevAccount())
            .append("revName", getRevName())
            .append("revPhone", getRevPhone())
            .append("revStatus", getRevStatus())
            .append("revWeight", getRevWeight())
            .append("revTime", getRevTime())
            .toString();
    }
}
