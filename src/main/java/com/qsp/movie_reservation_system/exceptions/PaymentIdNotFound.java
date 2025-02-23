package com.qsp.movie_reservation_system.exceptions;

public class PaymentIdNotFound extends RuntimeException {

	private String message = "Payment Id has Not found";

	public String getMessage() {
		return message;
	}
}
