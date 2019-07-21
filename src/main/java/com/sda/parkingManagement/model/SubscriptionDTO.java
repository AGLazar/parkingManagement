package com.sda.parkingManagement.model;

import java.util.Date;

public class SubscriptionDTO {
    private String code;
    private Date endDate;
    private Date startDate;

    public SubscriptionDTO(String code, Date endDate, Date startDate) {
        this.code = code;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public SubscriptionDTO(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}


