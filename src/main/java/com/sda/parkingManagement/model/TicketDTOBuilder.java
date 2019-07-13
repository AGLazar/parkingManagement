package com.sda.parkingManagement.model;

public final class TicketDTOBuilder {
    private String code;

    private TicketDTOBuilder() {
    }

    public static TicketDTOBuilder aTicketDTO() {
        return new TicketDTOBuilder();
    }

    public TicketDTOBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public TicketDTO build() {
        return new TicketDTO(code);
    }
}
