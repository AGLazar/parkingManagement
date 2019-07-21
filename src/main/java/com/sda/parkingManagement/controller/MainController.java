package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.SubscriptionDTO;
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

import java.util.Date;
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
            if (Objects.nonNull(subscriptionService.findSubscriptionByCode(code))) {
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


    @PostMapping(value = "/createSubscription",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSubscription(SubscriptionDTO subscriptionDTO, Model model) {
        String code = subscriptionDTO.getCode();
        Date startDate = subscriptionDTO.getStartDate();
        Date endDate = subscriptionDTO.getEndDate();
        SubscriptionDTO response = subscriptionService.createSubscription();
        model.addAttribute("ticketCode", response.getCode());
        return "publicPage";
    }

    public void exitParking(Ticket ticket) {
    }

    @PostMapping(value = "/payTicket",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String payTicket(TicketDTO ticketDTO, Model model) {
        long response = ticketService.calculatePrice(ticketDTO.getCode());
        model.addAttribute("price", response);
        return "publicPage";
    }






}
