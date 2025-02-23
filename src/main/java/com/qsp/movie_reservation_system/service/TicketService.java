package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.movie_reservation_system.dao.TicketDao;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructure1<Ticket> responseStructure1;
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket insterted into Database");
		responseStructure.setData(ticketDao.saveTicket(ticket));

		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Ticket Fetched from Database");
        responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return responseStructure;

	}
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId,Ticket newTicket) {
		
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket Updated from Database");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return responseStructure ;
	}
	
	public ResponseStructure1<Ticket> fetchAllTicket(){
		
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Tickets fetched from Database");
		responseStructure1.setData(ticketDao.fetchAllTicket());
		return responseStructure1;
		
	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId){
		
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket delete from Database");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure ;
		
	}
	
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(int paymentId,int ticketId){
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing payment to Ticket");
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId));
		return responseStructure ;
	}

}
