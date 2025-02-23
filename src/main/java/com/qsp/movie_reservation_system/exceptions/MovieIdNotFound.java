package com.qsp.movie_reservation_system.exceptions;

public class MovieIdNotFound extends RuntimeException {

	private String message = "Movie Id has Not found";

	public String getMessage() {
		return message;
	}
}
