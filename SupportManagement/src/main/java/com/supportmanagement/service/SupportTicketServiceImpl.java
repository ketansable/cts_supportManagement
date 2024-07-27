package com.supportmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportmanagement.entity.SupportTicket;
import com.supportmanagement.repository.SupportTicketRepository;

@Service
public class SupportTicketServiceImpl implements SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @Override
    public SupportTicket createSupportTicket(SupportTicket supportTicket) {
        supportTicket.setStatus("Pending");
        return supportTicketRepository.save(supportTicket);
    }
    
    @Override
    public List<SupportTicket> getOpenSupportTickets() {
        return supportTicketRepository.findByStatus("open");
    }

    @Override
    public SupportTicket updateSupportTicketStatus(Long ticketId, String status) {
        SupportTicket ticket = supportTicketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        return supportTicketRepository.save(ticket);
    }
}
