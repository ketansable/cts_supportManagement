package com.supportmanagement.controller;

import com.supportmanagement.entity.SupportTicket;
import com.supportmanagement.service.SupportTicketService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;

    @PostMapping
    public ResponseEntity<?> createSupportTicket(@RequestBody SupportTicket supportTicket) {
        if (supportTicket.getCustomerId() == null || supportTicket.getIssue() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Invalid request format"));
        }

        SupportTicket createdTicket = supportTicketService.createSupportTicket(supportTicket);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("ticketId", createdTicket.getTicketId()));
    }
    
    @GetMapping
    public ResponseEntity<?> getOpenSupportTickets() {
        List<SupportTicket> openTickets = supportTicketService.getOpenSupportTickets();
        if (openTickets.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("error", "No tickets found"));
        }
        return ResponseEntity.ok(openTickets);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateSupportTicketStatus(@PathVariable Long ticketId, @RequestBody Map<String, String> statusUpdate) {
        String status = statusUpdate.get("status");
        SupportTicket updatedTicket = supportTicketService.updateSupportTicketStatus(ticketId, status);
        return ResponseEntity.ok(updatedTicket);
    }
}

