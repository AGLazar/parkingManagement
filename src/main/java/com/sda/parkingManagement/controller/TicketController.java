package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/tickets")
public class TicketController {

    public TicketService ticketService;

    @Autowired

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
