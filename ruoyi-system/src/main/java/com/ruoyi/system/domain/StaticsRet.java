package com.ruoyi.system.domain;

/**
 * Created by MR.Wu on 2019-12-30.
 */
public class StaticsRet {

    /**
     * 当日未被确认的订单总额
     */
    private String nowDayNoComfireOrderTotal;

    /**
     * 当日已被确认的订单总额
     */
    private String nowDayYesComfireOrderTotal;

    /**
     * 当月未被确认的订单总额
     */
    private String nowMonthNoComfireOrderTotal;

    /**
     * 当月已被确认的订单总额
     */
    private String nowMonthYesComfireOrderTotal;

    /**
     * 当天新注册的用户
     */
    private String newUserTotal;

    /**
     * 总用户数
     */
    private String userTotal;

    public String getNowDayNoComfireOrderTotal() {
        return nowDayNoComfireOrderTotal;
    }

    public void setNowDayNoComfireOrderTotal(String nowDayNoComfireOrderTotal) {
        this.nowDayNoComfireOrderTotal = nowDayNoComfireOrderTotal;
    }

    public String getNowDayYesComfireOrderTotal() {
        return nowDayYesComfireOrderTotal;
    }

    public void setNowDayYesComfireOrderTotal(String nowDayYesComfireOrderTotal) {
        this.nowDayYesComfireOrderTotal = nowDayYesComfireOrderTotal;
    }

    public String getNowMonthNoComfireOrderTotal() {
        return nowMonthNoComfireOrderTotal;
    }

    public void setNowMonthNoComfireOrderTotal(String nowMonthNoComfireOrderTotal) {
        this.nowMonthNoComfireOrderTotal = nowMonthNoComfireOrderTotal;
    }

    public String getNowMonthYesComfireOrderTotal() {
        return nowMonthYesComfireOrderTotal;
    }

    public void setNowMonthYesComfireOrderTotal(String nowMonthYesComfireOrderTotal) {
        this.nowMonthYesComfireOrderTotal = nowMonthYesComfireOrderTotal;
    }

    public String getNewUserTotal() {
        return newUserTotal;
    }

    public void setNewUserTotal(String newUserTotal) {
        this.newUserTotal = newUserTotal;
    }

    public String getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(String userTotal) {
        this.userTotal = userTotal;
    }
}
