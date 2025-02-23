package com.qsp.movie_reservation_system.exceptions;

public class StaffIdNotFound extends RuntimeException{

	private String message = "Staff Id has Not found";

	public String getMessage() {
		return message;
	}
}
