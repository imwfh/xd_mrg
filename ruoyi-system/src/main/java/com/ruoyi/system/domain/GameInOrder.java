package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户下zhu记录表 game_in_order
 * 
 * @author ruoyi
 * @date 2020-07-25
 */
public class GameInOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** 用户编码 */
	private String userCode;
	/** 期数 */
	private String stageNo;
	/** 购买号码记录 */
	private String inNums;
	/** 名次 */
	private String inRank;
	/** 支出多少积分 */
	private BigDecimal inJf;
	/** 将要收获多少积分 */
	private BigDecimal revJf;
	/** 下单倍数 */
	private Integer inTimes;
	/** 添加时间 */
	private Date addTime;
	/** 0 = 待中 1 = 已中 -1 = 无效 */
	private Integer status;
	/** 0:赛车  1:飞艇 */
	private Integer gameType;

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
	public void setStageNo(String stageNo) 
	{
		this.stageNo = stageNo;
	}

	public String getStageNo() 
	{
		return stageNo;
	}
	public void setInNums(String inNums) 
	{
		this.inNums = inNums;
	}

	public String getInNums() 
	{
		return inNums;
	}
	public void setInRank(String inRank) 
	{
		this.inRank = inRank;
	}

	public String getInRank() 
	{
		return inRank;
	}
	public void setInJf(BigDecimal inJf) 
	{
		this.inJf = inJf;
	}

	public BigDecimal getInJf() 
	{
		return inJf;
	}
	public void setRevJf(BigDecimal revJf) 
	{
		this.revJf = revJf;
	}

	public BigDecimal getRevJf() 
	{
		return revJf;
	}
	public void setInTimes(Integer inTimes) 
	{
		this.inTimes = inTimes;
	}

	public Integer getInTimes() 
	{
		return inTimes;
	}
	public void setAddTime(Date addTime) 
	{
		this.addTime = addTime;
	}

	public Date getAddTime() 
	{
		return addTime;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setGameType(Integer gameType) 
	{
		this.gameType = gameType;
	}

	public Integer getGameType() 
	{
		return gameType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userCode", getUserCode())
            .append("stageNo", getStageNo())
            .append("inNums", getInNums())
            .append("inRank", getInRank())
            .append("inJf", getInJf())
            .append("revJf", getRevJf())
            .append("inTimes", getInTimes())
            .append("addTime", getAddTime())
            .append("status", getStatus())
            .append("gameType", getGameType())
            .toString();
    }
}
