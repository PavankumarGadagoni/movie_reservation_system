package com.qsp.movie_reservation_system.exceptions;

public class ManagerIdNotFound extends RuntimeException {
	private String message = "Manager Id has Not found";

	public String getMessage() {
		return message;
	}
}
