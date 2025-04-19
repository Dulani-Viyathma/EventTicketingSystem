package com.example.demo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketPool ticketPool;
    private int nextId = 1;

    public TicketService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public Ticket createTicket(String eventName, BigDecimal price, String status) {
        Ticket ticket = new Ticket(nextId++, eventName, price, status);
        ticketPool.addTicket(ticket);
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return ticketPool.getTickets();
    }
}
