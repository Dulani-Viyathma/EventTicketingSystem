package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public Ticket createTicket(@RequestParam String eventName, @RequestParam BigDecimal ticketPrice, @RequestParam String status) {
        return ticketService.createTicket(eventName, ticketPrice, status);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}