package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by MR.Wu on 2020-10-19.
 */
public class DataChildren {

    private String name;

    private BigDecimal value;

    private List<DataChildren> children;

    public List<DataChildren> getChildren() {
        return children;
    }

    public void setChildren(List<DataChildren> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
