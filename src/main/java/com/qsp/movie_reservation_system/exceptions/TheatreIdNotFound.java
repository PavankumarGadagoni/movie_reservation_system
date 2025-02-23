package com.qsp.movie_reservation_system.exceptions;

public class TheatreIdNotFound extends RuntimeException {

	private String message = "Theatre Id has Not found";

	public String getMessage() {
		return message;
	}
}
