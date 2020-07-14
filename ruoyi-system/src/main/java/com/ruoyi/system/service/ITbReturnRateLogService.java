package com.ruoyi.system.service;

import com.ruoyi.system.domain.TbReturnRateLog;

import java.util.List;

/**
 * 用户费率日志记录 服务层
 *
 * @author ruoyi
 * @date 2019-08-06
 */
public interface ITbReturnRateLogService {
    /**
     * 查询用户费率日志记录信息
     *
     * @param id 用户费率日志记录ID
     * @return 用户费率日志记录信息
     */
    public TbReturnRateLog selectTbReturnRateLogById(Long id);

    /**
     * 查询用户费率日志记录列表
     *
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 用户费率日志记录集合
     */
    public List<TbReturnRateLog> selectTbReturnRateLogList(TbReturnRateLog tbReturnRateLog);

    /**
     * 新增用户费率日志记录
     *
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 结果
     */
    public int insertTbReturnRateLog(TbReturnRateLog tbReturnRateLog);

    /**
     * 修改用户费率日志记录
     *
     * @param tbReturnRateLog 用户费率日志记录信息
     * @return 结果
     */
    public int updateTbReturnRateLog(TbReturnRateLog tbReturnRateLog);

    /**
     * 删除用户费率日志记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbReturnRateLogByIds(String ids);

}
