package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    public TicketService ticketService;



    @Autowired
    public MainController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index(Model model){
        return "publicPage";
    }

    @PostMapping (value = "/accesParking")
    public void accesParking (Ticket ticket){
        ticketService.createTicket();
    }

    public void exitParking(Ticket ticket){
    }







}
