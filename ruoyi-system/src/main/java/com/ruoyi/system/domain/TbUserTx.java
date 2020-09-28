package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 提现记录表 tb_user_tx
 * 
 * @author ruoyi
 * @date 2019-12-28
 */
public class TbUserTx extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 提现业务号 */
	private String txSn;
	/** 用户唯一编码 */
	private String userCode;
	private String userName;
	/** 提现的金额 */
	private BigDecimal userTxMoney;
	/** 提现前的余额 */
	private BigDecimal userBeforeTxMoney;
	/** 提现后的余额(结余) */
	private BigDecimal userAfterTxMoney;
	/** 被扣除的金额 */
	private BigDecimal userKouMoney;
	/** 用户实际到账金额 */
	private BigDecimal userGetMoney;
	/** 备注 */
	private String userDesc;
	private String btcCode;

	private String bankNo;

	private String bankUserName;

	private String bankName;
	/** 0:提现中 1:提现成功 -1:提现失败 */
	private Integer txStatus;

	//**100:本金钱包提现   101:用户收益流水钱包  102:赢利钱包提现

	private Integer txType;

	public String getBtcCode() {
		return btcCode;
	}

	public void setBtcCode(String btcCode) {
		this.btcCode = btcCode;
	}

	public String getBankUserName() {
		return bankUserName;
	}

	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getTxType() {
		return txType;
	}

	public void setTxType(Integer txType) {
		this.txType = txType;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setTxSn(String txSn) 
	{
		this.txSn = txSn;
	}

	public String getTxSn() 
	{
		return txSn;
	}
	public void setUserCode(String userCode) 
	{
		this.userCode = userCode;
	}

	public String getUserCode() 
	{
		return userCode;
	}
	public void setUserTxMoney(BigDecimal userTxMoney)
	{
		this.userTxMoney = userTxMoney;
	}

	public BigDecimal getUserTxMoney()
	{
		return userTxMoney;
	}
	public void setUserBeforeTxMoney(BigDecimal userBeforeTxMoney)
	{
		this.userBeforeTxMoney = userBeforeTxMoney;
	}

	public BigDecimal getUserBeforeTxMoney()
	{
		return userBeforeTxMoney;
	}
	public void setUserAfterTxMoney(BigDecimal userAfterTxMoney)
	{
		this.userAfterTxMoney = userAfterTxMoney;
	}

	public BigDecimal getUserAfterTxMoney()
	{
		return userAfterTxMoney;
	}
	public void setUserKouMoney(BigDecimal userKouMoney)
	{
		this.userKouMoney = userKouMoney;
	}

	public BigDecimal getUserKouMoney()
	{
		return userKouMoney;
	}
	public void setUserGetMoney(BigDecimal userGetMoney)
	{
		this.userGetMoney = userGetMoney;
	}

	public BigDecimal getUserGetMoney()
	{
		return userGetMoney;
	}
	public void setUserDesc(String userDesc) 
	{
		this.userDesc = userDesc;
	}

	public String getUserDesc() 
	{
		return userDesc;
	}
	public void setBankNo(String bankNo) 
	{
		this.bankNo = bankNo;
	}

	public String getBankNo() 
	{
		return bankNo;
	}
	public void setTxStatus(Integer txStatus) 
	{
		this.txStatus = txStatus;
	}

	public Integer getTxStatus() 
	{
		return txStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("txSn", getTxSn())
            .append("userCode", getUserCode())
            .append("userTxMoney", getUserTxMoney())
            .append("userBeforeTxMoney", getUserBeforeTxMoney())
            .append("userAfterTxMoney", getUserAfterTxMoney())
            .append("userKouMoney", getUserKouMoney())
            .append("userGetMoney", getUserGetMoney())
            .append("userDesc", getUserDesc())
            .append("bankNo", getBankNo())
            .append("txStatus", getTxStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
