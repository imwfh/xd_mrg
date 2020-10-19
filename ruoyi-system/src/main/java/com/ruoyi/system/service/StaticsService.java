package com.ruoyi.system.service;

import com.ruoyi.system.domain.DataChildren;
import com.ruoyi.system.domain.StaticsRet;

/**
 * Created by MR.Wu on 2019-12-30.
 */
public interface StaticsService {

    public StaticsRet getStatic();

    DataChildren getRelations();
}
