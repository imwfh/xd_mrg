package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏配置表 sy_game_config
 * 
 * @author ruoyi
 * @date 2020-07-14
 */
public class SyGameConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 参数主键 */
	private Integer id;
	/** 游戏名称 */
	private String gameName;
	/** 游戏页面路由 */
	private String gamePath;
	/** 游戏图标地址 */
	private String gameIco;
	/** 游戏状态 */
	private Integer gameStatus;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setGameName(String gameName) 
	{
		this.gameName = gameName;
	}

	public String getGameName() 
	{
		return gameName;
	}
	public void setGamePath(String gamePath) 
	{
		this.gamePath = gamePath;
	}

	public String getGamePath() 
	{
		return gamePath;
	}
	public void setGameIco(String gameIco) 
	{
		this.gameIco = gameIco;
	}

	public String getGameIco() 
	{
		return gameIco;
	}
	public void setGameStatus(Integer gameStatus) 
	{
		this.gameStatus = gameStatus;
	}

	public Integer getGameStatus() 
	{
		return gameStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gameName", getGameName())
            .append("gamePath", getGamePath())
            .append("gameIco", getGameIco())
            .append("gameStatus", getGameStatus())
            .toString();
    }
}
