package com.sda.parkingManagement.service;

import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.model.TicketDTO;
import com.sda.parkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.sda.parkingManagement.model.TicketDTOBuilder.aTicketDTO;

@Service
public class TicketService {

    private static final Integer PRICE_PER_HOUR = 2;

    @Autowired
    public TicketRepository ticketRepository;


    public TicketDTO createTicket() {
        Ticket ticket = new Ticket();
        ticket.setCode(generateRandomCode());
        Date date = new Date();
        ticket.setEnterDate(date);
        ticketRepository.save(ticket);

        return aTicketDTO()
                .withCode(ticket.getCode())
                .build();
    }

    public String generateRandomCode() {
        Date date = new Date();
        return "T" + date.getTime();
    }

    public long calculatePrice(String code) {
        Ticket ticket = ticketRepository.getTicketByCode(code);
        return PRICE_PER_HOUR * calculatePeriod(ticket);

    }

    public long calculatePeriod(Ticket ticket) {
        long diffInMin = new Date().getTime() - ticket.getEnterDate().getTime();
        return TimeUnit.HOURS.convert(diffInMin, TimeUnit.MILLISECONDS);
    }


    public boolean payTicket(String code){
        Ticket ticket = ticketRepository.getTicketByCode(code);

        if(ticket == null)
            return false;

        //TODO: calculate
        long payedAmount = calculatePrice(code);

        //TODO set payed amount and payed date
        Date currentTime = new Date();
        ticket.setPayDate(currentTime);
        ticket.setPayedAmount(payedAmount);
        ticketRepository.save(ticket);
        return true;
    }

    public boolean exit(String code){
        Ticket ticket = ticketRepository.getTicketByCode(code);
        if (ticket == null)
            return false;
        if (ticket.getPayDate().getTime() > new Date().getTime() + 30){
            return false;
        } else {
            return true;
        }
    }
}
