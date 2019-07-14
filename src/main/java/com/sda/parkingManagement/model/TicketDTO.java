package com.sda.parkingManagement.model;

public class TicketDTO {
    private String code;

    public TicketDTO(String code) {
        this.code = code;
    }

    public TicketDTO() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
