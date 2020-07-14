package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户表 tb_user
 * 
 * @author ruoyi
 * @date 2019-06-29
 */
public class TbUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long userId;
	/** 用户唯一编码 */
	private String userCode;
	/** 用户名 */
	private String username;
	/** 手机号 */
	private String mobile;
	/** 密码 */
	private String password;

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getUsername() 
	{
		return username;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userCode", getUserCode())
            .append("username", getUsername())
            .append("mobile", getMobile())
            .append("password", getPassword())
            .append("createTime", getCreateTime())
            .toString();
    }
}
