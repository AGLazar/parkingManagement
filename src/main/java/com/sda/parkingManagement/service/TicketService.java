package com.sda.parkingManagement.service;

import com.sda.parkingManagement.model.Ticket;
import com.sda.parkingManagement.model.TicketDTO;
import com.sda.parkingManagement.model.TicketDTOBuilder;
import com.sda.parkingManagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

import static com.sda.parkingManagement.model.TicketDTOBuilder.aTicketDTO;

@Service
public class TicketService {

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

    public String generateRandomCode(){
        Date date = new Date();
        return "T" + date.getTime();
    }

}
