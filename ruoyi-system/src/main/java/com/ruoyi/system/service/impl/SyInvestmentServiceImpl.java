package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.InvestmentRet;
import com.ruoyi.system.domain.SyInvestment;
import com.ruoyi.system.domain.TbProfitUser;
import com.ruoyi.system.mapper.SyInvestmentMapper;
import com.ruoyi.system.service.ISyInvestmentService;
import com.ruoyi.system.service.ITbProfitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户投资 服务层实现
 *
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class SyInvestmentServiceImpl implements ISyInvestmentService {
    @Autowired
    private SyInvestmentMapper syInvestmentMapper;

    @Autowired
    private ITbProfitUserService iTbProfitUserService;

    /**
     * 查询用户投资信息
     *
     * @param id 用户投资ID
     * @return 用户投资信息
     */
    @Override
    public SyInvestment selectSyInvestmentById(Integer id) {
        return syInvestmentMapper.selectSyInvestmentById(id);
    }

    /**
     * 查询用户投资列表
     *
     * @param syInvestment 用户投资信息
     * @return 用户投资集合
     */
    @Override
    public InvestmentRet selectSyInvestmentList(SyInvestment syInvestment) {
        List<SyInvestment> syInvestments = syInvestmentMapper.selectSyInvestmentList(syInvestment);
        //计算总金额
        Double totalMoney = syInvestments.stream().mapToDouble(SyInvestment::getInvestmentMoney).sum();
        InvestmentRet r = new InvestmentRet();
        r.setTotalMoney(totalMoney);
        r.setListData(syInvestments);
        return r;
    }

    /**
     * 新增用户投资
     *
     * @param syInvestment 用户投资信息
     * @return 结果
     */
    @Override
    public int insertSyInvestment(SyInvestment syInvestment) {
        return syInvestmentMapper.insertSyInvestment(syInvestment);
    }

    /**
     * 修改用户投资
     *
     * @param syInvestment 用户投资信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSyInvestment(SyInvestment syInvestment) {
        syInvestment.setComfirmTime(new Date());
        SyInvestment si = selectSyInvestmentById(syInvestment.getId());
        TbProfitUser user = iTbProfitUserService.selectTbProfitUserByUserCode(si.getUserCode());
        //将订单中的余额更新到用户账户中 只有当审核通过时才会执行
        if (new Integer("1").compareTo(syInvestment.getPlatformComfirm()) == 0 && null != user) {
            BigDecimal orderMoney = si.getRevertMoney().setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal userMoney = user.getUserMoney();
            BigDecimal totalMoney = userMoney.add(orderMoney).setScale(2, BigDecimal.ROUND_HALF_UP);

            BigDecimal tm = user.getTotalMoney();
            BigDecimal total = tm.add(syInvestment.getRevertMoney());

            //更新余额
            Map<String, Object> p = new HashMap<>();
            p.put("userCode", si.getUserCode());
            p.put("userMoney", totalMoney);
           // p.put("userTotalMoney", total);
            p.put("version", user.getVersion());
            int i = iTbProfitUserService.updateMoney(p);
            int y = syInvestmentMapper.updateSyInvestment(syInvestment);

            return i > 0 && y > 0 ? 1 : -1;
        }
//        else {
//            BigDecimal tm = user.getTotalMoney();
//            BigDecimal total = tm.add(syInvestment.getRevertMoney());
//            Map<String, Object> p = new HashMap<>();
//            p.put("userCode", si.getUserCode());
//            p.put("userTotalMoney", total);
//            iTbProfitUserService.updateMoney(p);
//            int y = syInvestmentMapper.updateSyInvestment(syInvestment);
//            return y;
//        }
        return 0;
    }

    /**
     * 删除用户投资对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSyInvestmentByIds(String ids) {
        return syInvestmentMapper.deleteSyInvestmentByIds(Convert.toStrArray(ids));
    }

}
