package com.sda.parkingManagement.model;

import java.util.Date;

public class Subscription {
    private Long id;
    private Date startDate;
    private Date endDate;
    private String code;

    public Subscription(Long id, Date startDate, Date endDate, String code) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
    }

    public Subscription(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
