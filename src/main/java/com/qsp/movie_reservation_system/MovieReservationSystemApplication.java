package com.qsp.movie_reservation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieReservationSystemApplication{

	
	// OneToOne
	/* -->Owner to Theatre
	 * -->Branch to Manager
	 * --> Branch to Address
	 * --> ticket to payment
	 * -->screen to movie
	 * --> viewer to seat
	*/
	
	//OneToMany
	/*
	 * Theatre to Branch
	 * Branch to Staff
	 * Branch to screen
	 * screen to seat
	 * Movie to viewer
	 * viewer to food
	 * viewer to ticket
	 * movie to review
	 * */
	
	public static void main(String[] args) {
		SpringApplication.run(MovieReservationSystemApplication.class, args);
	}

}
