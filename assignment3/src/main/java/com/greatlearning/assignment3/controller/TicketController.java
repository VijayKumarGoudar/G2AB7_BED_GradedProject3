package com.greatlearning.assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.assignment3.entity.Ticket;
import com.greatlearning.assignment3.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/tickets")
	public String getTickets(Model model) {

		List<Ticket> ticketList = ticketService.getTickets();
		model.addAttribute("ticketList", ticketList);
		return "tickets";
	}

	@GetMapping("/search")
	public String searchTicket(Model model, String keyword) {
		List<Ticket> ticketList = ticketService.getTicketsByKeyWord(keyword);
		model.addAttribute("ticketList", ticketList);
		return "tickets";
	}

	@GetMapping("/editTicketForm/{id}")
	public String editTicketForm(@PathVariable("id") long id, Model model) {

		Ticket ticket = ticketService.getTicket(id);
		model.addAttribute("ticket", ticket);
		return "edit_ticket";
	}

	@PostMapping("/createTicket")
	public String createTicket(@ModelAttribute("employee") Ticket ticket) {
		ticketService.createTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/showTicketForm")
	public String showNewTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}

	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable("id") long id) {
		ticketService.deleteEmployee(id);
		return "redirect:/tickets";
	}

	@GetMapping("/viewTicket/{id}")
	public String viewTicket(@PathVariable("id") long id, Model model) {
		Ticket ticket = ticketService.getTicket(id);
		model.addAttribute("ticket", ticket);
		return "view_ticket";
	}
}
