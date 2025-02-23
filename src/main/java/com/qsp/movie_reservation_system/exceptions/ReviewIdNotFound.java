package com.qsp.movie_reservation_system.exceptions;

public class ReviewIdNotFound extends RuntimeException{

	private String message = "Review Id has Not found";

	public String getMessage() {
		return message;
	}
}
