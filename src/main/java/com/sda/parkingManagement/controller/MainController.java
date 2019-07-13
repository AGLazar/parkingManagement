package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.model.TicketDTO;
import com.sda.parkingManagement.service.SubscriptionService;
import com.sda.parkingManagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    public TicketService ticketService;
    public SubscriptionService subscriptionService;



    @Autowired
    public MainController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index(Model model){
        return "publicPage";
    }
    //model get atriburte
    @PostMapping (value = "/accesParking",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String accesParking (TicketDTO ticketDTO, Model model){
        TicketDTO response = ticketService.createTicket();
        model.addAttribute("ticketCode", response.getCode());
        return "publicPage";
    }


    @PostMapping (value = "/createSubscription")
    public void createSubscription (Subscription subscription){
        subscriptionService.createSubscription();
    }

    public void exitParking(Ticket ticket){
    }







}
