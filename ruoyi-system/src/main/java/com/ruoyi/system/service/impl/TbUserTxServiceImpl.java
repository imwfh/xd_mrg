package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TbProfitUser;
import com.ruoyi.system.domain.TbUserTx;
import com.ruoyi.system.mapper.TbUserTxMapper;
import com.ruoyi.system.service.ITbProfitUserService;
import com.ruoyi.system.service.ITbUserTxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提现记录 服务层实现
 *
 * @author ruoyi
 * @date 2019-12-28
 */
@Service
public class TbUserTxServiceImpl implements ITbUserTxService {

    public static final Logger log = LoggerFactory.getLogger(TbUserTxServiceImpl.class);


    @Autowired
    private TbUserTxMapper tbUserTxMapper;

    @Autowired
    private ITbProfitUserService userService;

    /**
     * 查询提现记录信息
     *
     * @param id 提现记录ID
     * @return 提现记录信息
     */
    @Override
    public TbUserTx selectTbUserTxById(Long id) {
        return tbUserTxMapper.selectTbUserTxById(id);
    }

    /**
     * 查询提现记录列表
     *
     * @param tbUserTx 提现记录信息
     * @return 提现记录集合
     */
    @Override
    public List<TbUserTx> selectTbUserTxList(TbUserTx tbUserTx) {
        return tbUserTxMapper.selectTbUserTxList(tbUserTx);
    }

    /**
     * 新增提现记录
     *
     * @param tbUserTx 提现记录信息
     * @return 结果
     */
    @Override
    public int insertTbUserTx(TbUserTx tbUserTx) {
        return tbUserTxMapper.insertTbUserTx(tbUserTx);
    }

    /**
     * 修改提现记录
     *
     * @param tbUserTx 提现记录信息
     * @return 结果
     * <p>本金钱包提现 USDT=(需提钱包值-需提钱包值*提现率)/汇率</p>
     * <p>用户收益流水钱包 与 赢利钱包 USDT=需提钱包值/汇率-1</p>
     */
    @Override
    public int updateTbUserTx(TbUserTx tbUserTx) {
        //当提现不通地时,需要给用户加回去  /** 0:提现中 1:提现成功 -1:提现失败 */
        Integer st = tbUserTx.getTxStatus();
        if (-1 == st) {
            TbUserTx txObj = this.selectTbUserTxById(tbUserTx.getId());
            log.info("审核不通过,回退金额 {}, 回退类型 {}, 回退金额 {}", txObj.getUserCode(), txObj.getTxType(), txObj.getUserTxMoney());
            TbProfitUser user = userService.selectTbProfitUserByUserCode(txObj.getUserCode());
            Map<String, Object> p = new HashMap();
            switch (txObj.getTxType()) {
                case 100: //本金钱包提现
                    BigDecimal userMoney = user.getUserMoney();
                    BigDecimal afMoney = userMoney.add(txObj.getUserTxMoney());
                    user.setUserMoney(afMoney);
                    p.put("userMoney", user.getUserMoney());
                    break;
                case 101: //用户收益流水钱包
                    BigDecimal syMoney = user.getUserSyMoney();
                    BigDecimal afSyMoney = syMoney.add(txObj.getUserTxMoney());
                    user.setUserSyMoney(afSyMoney);
                    p.put("userSyMoney", user.getUserSyMoney());
                    break;
                case 102: //赢利钱包
                    BigDecimal ylMoney = user.getUserYlMoney();
                    BigDecimal afYlMoney = ylMoney.add(txObj.getUserTxMoney());
                    user.setUserYlMoney(afYlMoney);
                    p.put("userYlMoney", user.getUserYlMoney());
                    break;
            }
            p.put("version", user.getVersion());
            p.put("userCode", user.getUserCode());
            userService.updateMoney(p);
        }
        return tbUserTxMapper.updateTbUserTx(tbUserTx);
    }

    /**
     * 删除提现记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbUserTxByIds(String ids) {
        return tbUserTxMapper.deleteTbUserTxByIds(Convert.toStrArray(ids));
    }

}
