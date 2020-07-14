package com.ruoyi.system.domain;

import java.util.List;

/**
 * Created by MR.Wu on 2019-12-28.
 */
public class InvestmentRet {

    private Double totalMoney;

    private List<SyInvestment> listData;

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<SyInvestment> getListData() {
        return listData;
    }

    public void setListData(List<SyInvestment> listData) {
        this.listData = listData;
    }
}
