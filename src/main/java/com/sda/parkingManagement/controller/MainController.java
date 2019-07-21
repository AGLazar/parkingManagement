package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.SubscriptionDTO;
import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.model.TicketDTO;
import com.sda.parkingManagement.service.SubscriptionService;
import com.sda.parkingManagement.service.TicketService;
import com.sda.parkingManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
public class MainController {

    private TicketService ticketService;
    private SubscriptionService subscriptionService;
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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

    public String createSubscription(SubscriptionDTO subscriptionDTO,
                                     Model model) {
        SubscriptionDTO responseS = subscriptionService.createSubscription(subscriptionDTO);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("generatedCode", responseS.getCode());
        model.addAttribute("startDate", dateFormat.format(responseS.getStartDate()));
        model.addAttribute("endDate", dateFormat.format(responseS.getEndDate()));

        return "publicPage";
    }


    @PostMapping(value = "/payTicket",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String payTicket(TicketDTO ticketDTO, Model model) {
        if (ticketDTO.isCalculated()) {
            boolean result = ticketService.payTicket(ticketDTO.getCode());

            if (result) {
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
    public String exit(TicketDTO ticketDTO, SubscriptionDTO subscriptionDTO, Model model) {
        boolean result = ticketService.exit(ticketDTO.getCode());
        boolean resultSubscription = subscriptionService.exit(ticketDTO.getCode());
        if (result) {
            model.addAttribute("validate", "I wish you a good journey!");
        } else {
            model.addAttribute("validate", "Your ticket is invalid!");
        }
        if (resultSubscription) {
            model.addAttribute("validate", "I wish you a good journey!");
        } else {
            model.addAttribute("validate", "Your ticket is invalid!");
        }
        return "publicPage";


    }
}

