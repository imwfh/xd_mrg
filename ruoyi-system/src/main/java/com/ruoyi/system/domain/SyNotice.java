package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 公告表 sy_notice
 * 
 * @author ruoyi
 * @date 2020-01-03
 */
public class SyNotice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 参数主键 */
	private Integer id;
	/** 公告标题 */
	private String noticeTitle;
	private String noticeTitleEn;
	/** 公告内容 */
	private String noticeContent;

	private String nc;

	private Integer noticeType;

	private Integer languageType;

	private String hashCode;

	public String getNoticeTitleEn() {
		return noticeTitleEn;
	}

	public void setNoticeTitleEn(String noticeTitleEn) {
		this.noticeTitleEn = noticeTitleEn;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public Integer getLanguageType() {
		return languageType;
	}

	public void setLanguageType(Integer languageType) {
		this.languageType = languageType;
	}

	public String getNc() {
		return nc;
	}

	public void setNc(String nc) {
		this.nc = nc;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setNoticeTitle(String noticeTitle) 
	{
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeTitle() 
	{
		return noticeTitle;
	}
	public void setNoticeContent(String noticeContent) 
	{
		this.noticeContent = noticeContent;
	}

	public String getNoticeContent() 
	{
		return noticeContent;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeContent", getNoticeContent())
            .append("createTime", getCreateTime())
            .toString();
    }
}
