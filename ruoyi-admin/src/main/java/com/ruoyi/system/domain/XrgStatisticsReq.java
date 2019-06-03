package com.ruoyi.system.domain;


import com.ruoyi.common.core.domain.BaseEntity;

public class XrgStatisticsReq  extends BaseEntity {

    private String year;
    private String month;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
