package com.demo.model.po;

import java.io.Serializable;

public class Bill implements Serializable {
    private Integer billId;
    private Integer bidId;
    private Integer period;
    private String billName;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getBillName() {        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }
}
