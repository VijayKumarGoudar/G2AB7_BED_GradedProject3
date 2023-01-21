package com.greatlearning.assignment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.assignment3.entity.Ticket;
import com.greatlearning.assignment3.repository.TicketRepo;

@Service
public class TicketService {

	@Autowired
	TicketRepo ticketRepo;

	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}

	public Ticket getTicket(long id) {
		return ticketRepo.findById(id).orElse(null);
	}

	public void createTicket(Ticket ticket) {
		ticketRepo.save(ticket);
	}

	public void deleteEmployee(long id) {
		ticketRepo.deleteById(id);
	}

	public List<Ticket> getTicketsByKeyWord(String keyword) {
		return ticketRepo.findByKeyword(keyword);
	}

}
