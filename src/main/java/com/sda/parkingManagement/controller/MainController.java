package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.model.TicketDTO;
import com.sda.parkingManagement.service.SubscriptionService;
import com.sda.parkingManagement.service.TicketService;
import com.sda.parkingManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class MainController {

    private TicketService ticketService;
    private SubscriptionService subscriptionService;
    private UserService userService;

    @Autowired
    public MainController(UserService userService, TicketService ticketService, SubscriptionService subscriptionService) {
        this.ticketService = ticketService;
        this.subscriptionService = subscriptionService;
        this.userService = userService;


    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "publicPage";
    }

    @PostMapping(value = "/accesParking",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    public String accesParking(TicketDTO ticketDTO, Model model) {

        String code = ticketDTO.getCode();
        if (!StringUtils.isEmpty(code)) {
            if (Objects.nonNull(subscriptionService.findSubscriptionByCode(code))){
                model.addAttribute("ticketCode", "SubscriptionFound");
            } else {
                model.addAttribute("ticketCode", "SubscriptionNotFound");
            }
        } else {
            TicketDTO response = ticketService.createTicket();
            model.addAttribute("ticketCode", response.getCode());
        }
        return "publicPage";
    }


    @PostMapping(value = "/createSubscription")
    public void createSubscription(Subscription subscription) {
        subscriptionService.createSubscription();
    }


    @PostMapping(value = "/payTicket",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String payTicket(TicketDTO ticketDTO, Model model){
        if(ticketDTO.isCalculated()) {
            boolean result = ticketService.payTicket(ticketDTO.getCode());

            if(result) {
                model.addAttribute("payedMessage", "Thank you");
            } else {
                model.addAttribute("payedMessage", "Error! Ticket not payed");
            }
        } else {
            long response = ticketService.calculatePrice(ticketDTO.getCode());
            model.addAttribute("price", response);
            model.addAttribute("calculated", true);
        }
        return "publicPage";
    }

    @PostMapping(value = "/exit",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String exit(TicketDTO ticketDTO, Model model) {
        boolean result = ticketService.exit(ticketDTO.getCode());
        if(result) {
            model.addAttribute("validate","I wish you a good journey!");
        } else {
            model.addAttribute("validate","Your ticket is invalid!");
        }
        return "publicPage";
    }
}
