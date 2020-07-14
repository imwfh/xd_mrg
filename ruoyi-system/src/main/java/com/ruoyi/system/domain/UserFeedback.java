package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 用户反馈表 user_feedback
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public class UserFeedback extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 反馈内容 */
	private String content;
	/** 平台回复内容 */
	private String replayContent;
	/** 反馈选项编码 */
	private String feedCode;
	/** 平台答复时间 */
	private Date ansTime;
	/**  */
	private String hashCode;
	/** 反馈人ID */
	private String userCode;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setReplayContent(String replayContent) 
	{
		this.replayContent = replayContent;
	}

	public String getReplayContent() 
	{
		return replayContent;
	}
	public void setFeedCode(String feedCode) 
	{
		this.feedCode = feedCode;
	}

	public String getFeedCode() 
	{
		return feedCode;
	}
	public void setAnsTime(Date ansTime) 
	{
		this.ansTime = ansTime;
	}

	public Date getAnsTime() 
	{
		return ansTime;
	}
	public void setHashCode(String hashCode) 
	{
		this.hashCode = hashCode;
	}

	public String getHashCode() 
	{
		return hashCode;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("replayContent", getReplayContent())
            .append("feedCode", getFeedCode())
            .append("createTime", getCreateTime())
            .append("ansTime", getAnsTime())
            .append("hashCode", getHashCode())
            .append("userCode", getUserCode())
            .toString();
    }
}
