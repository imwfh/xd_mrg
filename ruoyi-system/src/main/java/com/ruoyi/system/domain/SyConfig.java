package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 参数配置表 sy_config
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public class SyConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 参数主键 */
	private Integer id;
	/** 参数名称 */
	private String configName;
	/** 参数键名 */
	private String configKey;
	/** 参数键值 */
	private String configValue;
	/** 开始时间 */
	private String startTime;
	/** 结束时间 */
	private String endTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setConfigName(String configName) 
	{
		this.configName = configName;
	}

	public String getConfigName() 
	{
		return configName;
	}
	public void setConfigKey(String configKey) 
	{
		this.configKey = configKey;
	}

	public String getConfigKey() 
	{
		return configKey;
	}
	public void setConfigValue(String configValue) 
	{
		this.configValue = configValue;
	}

	public String getConfigValue() 
	{
		return configValue;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("remark", getRemark())
            .toString();
    }
}
