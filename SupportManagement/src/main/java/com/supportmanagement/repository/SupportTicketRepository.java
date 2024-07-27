package com.supportmanagement.repository;

import com.supportmanagement.entity.SupportTicket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
	List<SupportTicket> findByStatus(String status);
}

