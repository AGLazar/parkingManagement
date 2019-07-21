package com.sda.parkingManagement.model;

public class TicketDTO {
    private String code;
    private Boolean calculated;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean isCalculated() {
        return calculated == null ? false : calculated;
    }

    public void setCalculated(Boolean calculated) {
        this.calculated = calculated;
    }
}
