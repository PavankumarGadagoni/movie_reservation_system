package com.qsp.movie_reservation_system.exceptions;

public class ViewerIdNotFound extends RuntimeException {

	private String message = "Viewer Id has Not found";

	public String getMessage() {
		return message;
	}
}
