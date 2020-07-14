package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页轮播图表 sy_index_info
 * 
 * @author ruoyi
 * @date 2019-08-07
 */
public class SyIndexInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 快递公司名称 */
	private String indexUrl;
	/** 快递公司编码 */
	private String indexName;
	/** 状态 0- 展示中 -1-已关闭 */
	private Integer state;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setIndexUrl(String indexUrl) 
	{
		this.indexUrl = indexUrl;
	}

	public String getIndexUrl() 
	{
		return indexUrl;
	}
	public void setIndexName(String indexName) 
	{
		this.indexName = indexName;
	}

	public String getIndexName() 
	{
		return indexName;
	}
	public void setState(Integer state) 
	{
		this.state = state;
	}

	public Integer getState() 
	{
		return state;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("indexUrl", getIndexUrl())
            .append("indexName", getIndexName())
            .append("state", getState())
            .toString();
    }
}
