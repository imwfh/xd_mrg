package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 火币用户授权表 hb_api_user
 * 
 * @author ruoyi
 * @date 2021-06-07
 */
public class HbApiUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 用户唯一编码 */
	private String userCode;
	/** HB account id */
	private String accountId;
	/** HB account 类型 */
	private String accountType;
	/** HB account status  */
	private String accountState;
	/**  */
	private String apiKey;
	/**  */
	private String secretKey;
	/** 0 = 正常  -1 = 无效/解绑 */
	private Integer status;

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
	public void setAccountType(String accountType) 
	{
		this.accountType = accountType;
	}

	public String getAccountType() 
	{
		return accountType;
	}
	public void setAccountState(String accountState) 
	{
		this.accountState = accountState;
	}

	public String getAccountState() 
	{
		return accountState;
	}
	public void setApiKey(String apiKey) 
	{
		this.apiKey = apiKey;
	}

	public String getApiKey() 
	{
		return apiKey;
	}
	public void setSecretKey(String secretKey) 
	{
		this.secretKey = secretKey;
	}

	public String getSecretKey() 
	{
		return secretKey;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userCode", getUserCode())
            .append("accountId", getAccountId())
            .append("accountType", getAccountType())
            .append("accountState", getAccountState())
            .append("apiKey", getApiKey())
            .append("secretKey", getSecretKey())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
