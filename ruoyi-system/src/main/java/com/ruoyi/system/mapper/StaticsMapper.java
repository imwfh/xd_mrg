package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.UserStatInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by MR.Wu on 2019-12-30.
 */
public interface StaticsMapper {

    public List<BigDecimal> getStatis();

    BigDecimal getFillSum(Map<String, Object> param);

    BigDecimal getTxSum(Map<String, Object> param);

    UserStatInfo getUserWallet(Map<String, Object> param);
}
