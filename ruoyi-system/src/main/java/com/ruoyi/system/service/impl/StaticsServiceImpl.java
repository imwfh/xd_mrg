package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.StaticsRet;
import com.ruoyi.system.mapper.StaticsMapper;
import com.ruoyi.system.service.StaticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by MR.Wu on 2019-12-30.
 */
@Service
public class StaticsServiceImpl implements StaticsService {

    @Autowired
    private StaticsMapper staticsMapper;

    @Override
    public StaticsRet getStatic() {
        StaticsRet ret = new StaticsRet();
        List<BigDecimal> its = staticsMapper.getStatis();
        //当天新注册的用户
        ret.setNewUserTotal(its.get(0).toPlainString());
        //总用户数
        ret.setUserTotal(its.get(1).toPlainString());
        //当日未被确认的订单总额
        ret.setNowDayNoComfireOrderTotal(its.get(2).toPlainString());
        //当日已被确认的订单总额
        ret.setNowDayYesComfireOrderTotal(its.get(3).toPlainString());
        //当月未被确认的订单总额
        ret.setNowMonthNoComfireOrderTotal(its.get(4).toPlainString());
        //当月已被确认的订单总额
        ret.setNowMonthYesComfireOrderTotal(its.get(5).toPlainString());
        return ret;
    }
}
