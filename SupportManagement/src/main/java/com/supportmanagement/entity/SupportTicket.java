package com.supportmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    
    private Long customerId;
    private String issue;
    private String status;
}
