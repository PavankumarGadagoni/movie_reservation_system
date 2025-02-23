package com.qsp.movie_reservation_system.exceptions;

public class TicketIdNotFound extends RuntimeException {

	private String message = "Ticket Id has Not found";

	public String getMessage() {
		return message;
	}
}
