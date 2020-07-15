package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户基本表 tb_profit_user
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public class TbProfitUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long userId;
	/** 用户唯一编码 */
	private String userCode;
	private String userLevel;
	/** 是属于谁邀请的 销售与企业的关系 */
	private String parentCode;
	/** 用户名 */
	private String username;
	/** 手机号 */
	private String mobile;
	/** 密码 */
	private String password;
	/** 用户类型 -1:未认证用户 0:个人用户 1:企业用户 */
	private Integer userType;
	/**
	 * 0:资料等待审核 1:审核成功
	 */
	private Integer isExamine;

	private BigDecimal userGpfg;
	/** 用户状态 0:正常 -1:锁定 */
	private Integer userStatus;
	/** 是否认证 0:未能 1:已认证 */
	private Integer isAuth;
	/** 用户钱包值 充值的钱 */
	private BigDecimal userMoney;

	private BigDecimal userJbMoney;

	private BigDecimal userYlMoney;

	private BigDecimal userSyMoney;


	/** 用户所获得的返佣金额，可用于提现或支付 */
	private BigDecimal userReturnMoney;
	/** 是否是首次充值 0：未充过值  1:已经充值过 */
	private Integer isFirstFill;
	/** 当月累计充值 */
	private BigDecimal totalMoneyMonth;
	/** 总计充值 */
	private BigDecimal totalMoney;
	/** 钱包支付密码 */
	private String payPwd;
	/** 事务版本号 */
	private Integer version;
	/** 邀请码绑定时间 */
	private Date bindTime;
	/** 0:充值可以  1:不允许充值 */
	private Integer isHf;
	/** 是否有提现权限 -1:否  1:是 */
	private Integer isTx;
	/** 是否是无限代 0:不是  1:是 */
	private Integer isNoLimit;

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	private String btcCode;

	public String getBtcCode() {
		return btcCode;
	}

	public void setBtcCode(String btcCode) {
		this.btcCode = btcCode;
	}

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
	public void setParentCode(String parentCode) 
	{
		this.parentCode = parentCode;
	}

	public String getParentCode() 
	{
		return parentCode;
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
	public void setUserType(Integer userType) 
	{
		this.userType = userType;
	}

	public Integer getUserType() 
	{
		return userType;
	}
	public void setUserStatus(Integer userStatus) 
	{
		this.userStatus = userStatus;
	}

	public Integer getUserStatus() 
	{
		return userStatus;
	}
	public void setIsAuth(Integer isAuth) 
	{
		this.isAuth = isAuth;
	}

	public Integer getIsAuth() 
	{
		return isAuth;
	}
	public void setUserMoney(BigDecimal userMoney)
	{
		this.userMoney = userMoney;
	}

	public BigDecimal getUserMoney()
	{
		return userMoney;
	}
	public void setUserReturnMoney(BigDecimal userReturnMoney)
	{
		this.userReturnMoney = userReturnMoney;
	}

	public BigDecimal getUserReturnMoney()
	{
		return userReturnMoney;
	}
	public void setIsFirstFill(Integer isFirstFill) 
	{
		this.isFirstFill = isFirstFill;
	}

	public Integer getIsFirstFill() 
	{
		return isFirstFill;
	}
	public void setTotalMoneyMonth(BigDecimal totalMoneyMonth)
	{
		this.totalMoneyMonth = totalMoneyMonth;
	}

	public BigDecimal getTotalMoneyMonth()
	{
		return totalMoneyMonth;
	}
	public void setTotalMoney(BigDecimal totalMoney)
	{
		this.totalMoney = totalMoney;
	}

	public BigDecimal getTotalMoney()
	{
		return totalMoney;
	}
	public void setPayPwd(String payPwd) 
	{
		this.payPwd = payPwd;
	}

	public String getPayPwd() 
	{
		return payPwd;
	}
	public void setVersion(Integer version) 
	{
		this.version = version;
	}

	public Integer getVersion() 
	{
		return version;
	}
	public void setBindTime(Date bindTime) 
	{
		this.bindTime = bindTime;
	}

	public Date getBindTime() 
	{
		return bindTime;
	}
	public void setIsHf(Integer isHf) 
	{
		this.isHf = isHf;
	}

	public Integer getIsHf() 
	{
		return isHf;
	}
	public void setIsTx(Integer isTx) 
	{
		this.isTx = isTx;
	}

	public Integer getIsTx() 
	{
		return isTx;
	}
	public void setIsNoLimit(Integer isNoLimit) 
	{
		this.isNoLimit = isNoLimit;
	}

	public Integer getIsNoLimit() 
	{
		return isNoLimit;
	}

	public Integer getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(Integer isExamine) {
		this.isExamine = isExamine;
	}

	public BigDecimal getUserGpfg() {
		return userGpfg;
	}

	public void setUserGpfg(BigDecimal userGpfg) {
		this.userGpfg = userGpfg;
	}

	public BigDecimal getUserJbMoney() {
		return userJbMoney;
	}

	public void setUserJbMoney(BigDecimal userJbMoney) {
		this.userJbMoney = userJbMoney;
	}

	public BigDecimal getUserYlMoney() {
		return userYlMoney;
	}

	public void setUserYlMoney(BigDecimal userYlMoney) {
		this.userYlMoney = userYlMoney;
	}

	public BigDecimal getUserSyMoney() {
		return userSyMoney;
	}

	public void setUserSyMoney(BigDecimal userSyMoney) {
		this.userSyMoney = userSyMoney;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userCode", getUserCode())
            .append("parentCode", getParentCode())
            .append("username", getUsername())
            .append("mobile", getMobile())
            .append("password", getPassword())
            .append("userType", getUserType())
            .append("userStatus", getUserStatus())
            .append("isAuth", getIsAuth())
            .append("userMoney", getUserMoney())
            .append("userReturnMoney", getUserReturnMoney())
            .append("isFirstFill", getIsFirstFill())
            .append("totalMoneyMonth", getTotalMoneyMonth())
            .append("totalMoney", getTotalMoney())
            .append("payPwd", getPayPwd())
            .append("version", getVersion())
            .append("bindTime", getBindTime())
            .append("isHf", getIsHf())
            .append("isTx", getIsTx())
            .append("isNoLimit", getIsNoLimit())
            .append("createTime", getCreateTime())
            .toString();
    }
}
