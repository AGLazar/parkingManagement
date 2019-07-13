package com.sda.parkingManagement.model;

public class SubscriptionDTO {
    private String code;

    public SubscriptionDTO(String code) {
        this.code = code;
    }

    public SubscriptionDTO(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
