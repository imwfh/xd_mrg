package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * Created by MR.Wu on 2020-08-19.
 */
public class UserStatInfo {
    private BigDecimal userMoney;

    private BigDecimal userJbMoney;

    private BigDecimal userYlMoney;

    private BigDecimal userSyMoney;

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
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
}
