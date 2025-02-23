package com.qsp.movie_reservation_system.exceptions;

public class OwnerIdNotFound extends RuntimeException {

	private String message = "Owner Id has Not found";

	public String getMessage() {
		return message;
	}
	
	
}
