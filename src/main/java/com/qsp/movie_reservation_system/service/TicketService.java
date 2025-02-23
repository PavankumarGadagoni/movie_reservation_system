package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.PaymentDao;
import com.qsp.movie_reservation_system.dao.TicketDao;
import com.qsp.movie_reservation_system.dto.Payment;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.exceptions.PaymentIdNotFound;
import com.qsp.movie_reservation_system.exceptions.TicketIdNotFound;
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
	
	@Autowired
	PaymentDao paymentDao;
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Ticket insterted into Database");
		responseStructure.setData(ticketDao.saveTicket(ticket));

		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket dbTicket = ticketDao.fetchTicketById(ticketId);
		if(dbTicket != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Ticket Fetched from Database");
        responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return responseStructure;
		}
		throw new TicketIdNotFound();
	}
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId,Ticket newTicket) {
		Ticket dbTicket = ticketDao.fetchTicketById(oldTicketId);
		if(dbTicket != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket Updated from Database");
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return responseStructure ;
		}
		throw new TicketIdNotFound();
	}
	
	public ResponseStructure1<Ticket> fetchAllTicket(){
		
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Tickets fetched from Database");
		responseStructure1.setData(ticketDao.fetchAllTicket());
		return responseStructure1;
		
	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId){
		Ticket dbTicket = ticketDao.fetchTicketById(ticketId);
		if(dbTicket != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Ticket delete from Database");
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure ;
		}
		throw new TicketIdNotFound();
		
	}
	
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(int paymentId,int ticketId){
		Ticket dbTicket = ticketDao.fetchTicketById(ticketId);
		Payment dbPayment = paymentDao.fetchPaymentById(paymentId);
		if(dbTicket != null && dbPayment != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing payment to Ticket");
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(paymentId, ticketId));
		return responseStructure ;
		}
		else {
			if(dbPayment == null) throw new PaymentIdNotFound();
			else throw new TicketIdNotFound();
		}
	}

}
