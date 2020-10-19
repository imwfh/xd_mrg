package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.DataChildren;
import com.ruoyi.system.domain.StaticsRet;
import com.ruoyi.system.domain.TbProfitUser;
import com.ruoyi.system.domain.UserStatInfo;
import com.ruoyi.system.mapper.StaticsMapper;
import com.ruoyi.system.service.ITbProfitUserService;
import com.ruoyi.system.service.StaticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MR.Wu on 2019-12-30.
 */
@Service
public class StaticsServiceImpl implements StaticsService {

    @Autowired
    private StaticsMapper staticsMapper;

    @Autowired
    private ITbProfitUserService iTbProfitUserService;

    private static final Logger logger = LoggerFactory.getLogger("StaticsService");

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
        //当天申请提现人数
        ret.setNowDayUserTxTotal(its.get(6).toPlainString());
        //当天申请提现金额
        ret.setNowDayUserTxMoney(its.get(7).toPlainString());
        //当天通过申请提现人数
        ret.setNowDayPassUserTxTotal(its.get(8).toPlainString());
        //当天通过申请提现金额
        ret.setNowDayPassUserTxMoney(its.get(9).toPlainString());
        //所有通过申请提现人数
        ret.setAllPassTxTotal(its.get(10).toPlainString());
        //所有通过申请提现金额
        ret.setAllPassTxMoney(its.get(11).toPlainString());

        //沉淀利润=总充值-提现数
        Map<String, Object> p = new HashMap<>();

        //今天的沉淀利润
        p.clear();
        p.put("times", DateUtils.addOrDisOneDayOfNow(0));
        BigDecimal fillSumToday = staticsMapper.getFillSum(p);
        BigDecimal txSumToday = staticsMapper.getTxSum(p);
        BigDecimal fxt = fillSumToday.subtract(txSumToday);
        ret.setFxt(fxt);

        //所有沉淀利润
        BigDecimal fillSumAll = staticsMapper.getFillSum(null);
        BigDecimal txSumAll = staticsMapper.getTxSum(null);
        BigDecimal fxAll = fillSumAll.subtract(txSumAll);
        ret.setFxAll(fxAll);

        //净利润=总充值-提现数-用户账户总额度（四个钱包）

        //今天的净利润
        p.clear();
        p.put("times", DateUtils.addOrDisOneDayOfNow(0));
        UserStatInfo userStatInfo = staticsMapper.getUserWallet(p);
        BigDecimal r = null;
        if (null == userStatInfo) {
            r = new BigDecimal(0);
        } else {
            BigDecimal userWallet = userStatInfo.getUserJbMoney().add(userStatInfo.getUserMoney()).add(userStatInfo.getUserSyMoney()).add(userStatInfo.getUserYlMoney());
            r = fxt.subtract(userWallet);
        }
        ret.setFtl(r);

        //所有净利润
        UserStatInfo userStatInfoAll = staticsMapper.getUserWallet(null);
        BigDecimal rA = null;
        if (null == userStatInfoAll) {
            rA = new BigDecimal(0);
        } else {
            BigDecimal userWalletAll = userStatInfoAll.getUserJbMoney().add(userStatInfoAll.getUserMoney()).add(userStatInfoAll.getUserSyMoney()).add(userStatInfoAll.getUserYlMoney());
            rA = fxAll.subtract(userWalletAll);
        }
        ret.setFtlAll(rA);

        return ret;
    }

    private void findSubsUsers(String userCode, DataChildren root) {
        List<DataChildren> rootChildren = new ArrayList<>();
        List<TbProfitUser> users = iTbProfitUserService.findSubsUsersOfPrarent(userCode);
        users.stream().forEach(e -> {
            DataChildren sub = new DataChildren();
            sub.setName(e.getUsername()+" > " + e.getUserMoney() + " | " + e.getTotalMoney());
            sub.setValue(e.getTotalMoney());
            rootChildren.add(sub);
            findSubsUsers(e.getUserCode(), sub);
        });
        root.setChildren(rootChildren);
    }


    public DataChildren getRelations() {
        DataChildren root = new DataChildren();

        //先找到root根节点 即没有上级的用户
        TbProfitUser rootUser = iTbProfitUserService.findRootUser();
        root.setName(rootUser.getUsername());
        root.setValue(rootUser.getTotalMoney());
        findSubsUsers(rootUser.getUserCode(), root);

//        DataChildren root = new DataChildren();
//        List<DataChildren> rootChildren = new ArrayList<>();
//        root.setName("root");
//        root.setValue(12);
//
//        DataChildren root1L = new DataChildren();
//        root1L.setName("root1L");
//        root1L.setValue(120);
//        rootChildren.add(root1L);
//
//        DataChildren root2L = new DataChildren();
//        root2L.setName("root2L");
//        root2L.setValue(130);
//        rootChildren.add(root2L);
//
//        root.setChildren(rootChildren);
//        System.out.println(JSONObject.toJSONString(rootSubUsers));
        System.out.println(JSONObject.toJSONString(root));
        return root;
    }
}
