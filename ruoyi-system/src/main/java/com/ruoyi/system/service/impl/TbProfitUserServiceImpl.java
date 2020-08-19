package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TbProfitUser;
import com.ruoyi.system.mapper.TbProfitUserMapper;
import com.ruoyi.system.service.ITbProfitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户基本 服务层实现
 *
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class TbProfitUserServiceImpl implements ITbProfitUserService {
    @Autowired
    private TbProfitUserMapper tbProfitUserMapper;

    /**
     * 查询用户基本信息
     *
     * @param userId 用户基本ID
     * @return 用户基本信息
     */
    @Override
    public TbProfitUser selectTbProfitUserById(Long userId) {
        return tbProfitUserMapper.selectTbProfitUserById(userId);
    }

    @Override
    public TbProfitUser selectTbProfitUserByUserCode(String userCode) {
        return tbProfitUserMapper.selectTbProfitUserByUserCode(userCode);
    }

    @Override
    public int updateMoney(Map<String, Object> pram) {
        return tbProfitUserMapper.updateMoney(pram);
    }

    /**
     * 查询用户基本列表
     *
     * @param tbProfitUser 用户基本信息
     * @return 用户基本集合
     */
    @Override
    public List<TbProfitUser> selectTbProfitUserList(TbProfitUser tbProfitUser) {
        List<TbProfitUser> tpus = tbProfitUserMapper.selectTbProfitUserList(tbProfitUser);
        return tpus;
    }

    /**
     * 新增用户基本
     *
     * @param tbProfitUser 用户基本信息
     * @return 结果
     */
    @Override
    public int insertTbProfitUser(TbProfitUser tbProfitUser) {
        return tbProfitUserMapper.insertTbProfitUser(tbProfitUser);
    }

    /**
     * 修改用户基本
     *
     * @param tbProfitUser 用户基本信息
     * @return 结果
     */
    @Override
    public int updateTbProfitUser(TbProfitUser tbProfitUser) {
        return tbProfitUserMapper.updateTbProfitUser(tbProfitUser);
    }

    /**
     * 删除用户基本对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbProfitUserByIds(String ids) {
        return tbProfitUserMapper.deleteTbProfitUserByIds(Convert.toStrArray(ids));
    }

}
