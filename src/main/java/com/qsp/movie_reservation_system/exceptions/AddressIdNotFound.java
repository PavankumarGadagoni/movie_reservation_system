package com.qsp.movie_reservation_system.exceptions;

public class AddressIdNotFound extends RuntimeException {

	private String message = "Address Id has Not found";

	public String getMessage() {
		return message;
	}
}
