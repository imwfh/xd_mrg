package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户等级表 sy_game_rate
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public class SyGameRate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 会员名称 */
	private String name;
	/** 会员等级 */
	private Integer gradeNum;
	/** 团队流水 */
	private BigDecimal groupMoney;
	/** 返佣比例 */
	private BigDecimal profitRate;
	/** 说明 */
	private String gradeDesc;
	/** 添加时间 */
	private Date addTime;
	/** 是否删除.1=删除,0=未删除 */
	private Integer isDel;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setGradeNum(Integer gradeNum) 
	{
		this.gradeNum = gradeNum;
	}

	public Integer getGradeNum() 
	{
		return gradeNum;
	}
	public void setGroupMoney(BigDecimal groupMoney) 
	{
		this.groupMoney = groupMoney;
	}

	public BigDecimal getGroupMoney() 
	{
		return groupMoney;
	}
	public void setProfitRate(BigDecimal profitRate) 
	{
		this.profitRate = profitRate;
	}

	public BigDecimal getProfitRate() 
	{
		return profitRate;
	}
	public void setGradeDesc(String gradeDesc) 
	{
		this.gradeDesc = gradeDesc;
	}

	public String getGradeDesc() 
	{
		return gradeDesc;
	}
	public void setAddTime(Date addTime) 
	{
		this.addTime = addTime;
	}

	public Date getAddTime() 
	{
		return addTime;
	}
	public void setIsDel(Integer isDel) 
	{
		this.isDel = isDel;
	}

	public Integer getIsDel() 
	{
		return isDel;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("gradeNum", getGradeNum())
            .append("groupMoney", getGroupMoney())
            .append("profitRate", getProfitRate())
            .append("gradeDesc", getGradeDesc())
            .append("addTime", getAddTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
