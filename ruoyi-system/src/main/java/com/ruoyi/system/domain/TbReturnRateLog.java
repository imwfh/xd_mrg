package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 用户费率日志记录表 tb_return_rate_log
 *
 * @author ruoyi
 * @date 2019-08-06
 */
public class TbReturnRateLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 所对应下单动作用户的编码
     */
    private String parentCode;
    /**
     * 所对应的费率
     */
    private BigDecimal rate;
    /**
     * 返佣多少
     */
    private BigDecimal returnMoney;
    /**
     * 订单号
     */
    private String orderSn;

    private String parentMobile;

    private String parentUserName;

    private String username;

    private String mobile;

	public String getParentMobile() {
		return parentMobile;
	}

	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}

	public String getParentUserName() {
		return parentUserName;
	}

	public void setParentUserName(String parentUserName) {
		this.parentUserName = parentUserName;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userCode", getUserCode())
                .append("parentCode", getParentCode())
                .append("rate", getRate())
                .append("returnMoney", getReturnMoney())
                .append("orderSn", getOrderSn())
                .append("createTime", getCreateTime())
                .toString();
    }
}
