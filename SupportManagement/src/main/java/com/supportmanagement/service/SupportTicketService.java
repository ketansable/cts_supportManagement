package com.supportmanagement.service;

import java.util.List;

import com.supportmanagement.entity.SupportTicket;

public interface SupportTicketService {
    SupportTicket createSupportTicket(SupportTicket supportTicket);
    List<SupportTicket> getOpenSupportTickets();
    SupportTicket updateSupportTicketStatus(Long ticketId, String status);
}
