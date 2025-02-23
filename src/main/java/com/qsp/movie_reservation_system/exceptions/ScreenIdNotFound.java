package com.qsp.movie_reservation_system.exceptions;

public class ScreenIdNotFound extends RuntimeException {

	private String message = "Screen Id has Not found";

	public String getMessage() {
		return message;
	}
}
