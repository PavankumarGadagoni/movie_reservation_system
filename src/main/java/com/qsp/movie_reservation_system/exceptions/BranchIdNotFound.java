package com.qsp.movie_reservation_system.exceptions;

public class BranchIdNotFound extends RuntimeException {

	private String message = "Branch Id has Not found";

	public String getMessage() {
		return message;
	}
}
