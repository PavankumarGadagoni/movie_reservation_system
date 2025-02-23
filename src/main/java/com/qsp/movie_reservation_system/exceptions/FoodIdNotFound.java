package com.qsp.movie_reservation_system.exceptions;

public class FoodIdNotFound extends RuntimeException {

	private String message = "Food Id has Not found";

	public String getMessage() {
		return message;
	}
}
