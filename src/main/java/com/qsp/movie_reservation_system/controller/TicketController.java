package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.service.TicketService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {

		return ticketService.saveTicket(ticket);
	}
     
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {

		return ticketService.fetchTicketById(ticketId);
	}
	
	@PutMapping("/addExistingPaymentToExistingTicket")
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(@RequestParam int paymentId,@RequestParam int ticketId) {
		return ticketService.addExistingPaymentToExistingTicket(paymentId, ticketId);
	}
     
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {

		return ticketService.updateTicketById(oldTicketId, newTicket);
	}

	@GetMapping("/fetchAllTicket")
	public ResponseStructure1<Ticket> fetchAllTicket() {

		return ticketService.fetchAllTicket();
	}

	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {

		return ticketService.deleteTicketById(ticketId);

	}
	
}
