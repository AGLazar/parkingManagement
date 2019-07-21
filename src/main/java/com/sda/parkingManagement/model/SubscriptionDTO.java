package com.sda.parkingManagement.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SubscriptionDTO {
    private String code;
    private Date endDate;
    private Date startDate;

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


