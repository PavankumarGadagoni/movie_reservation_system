package com.qsp.movie_reservation_system.exceptions;

public class SeatIdNotFound extends RuntimeException {

	private String message = "Seat Id has Not found";

	public String getMessage() {
		return message;
	}
}
