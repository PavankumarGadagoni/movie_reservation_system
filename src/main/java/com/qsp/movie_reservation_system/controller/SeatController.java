package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.service.SeatService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class SeatController {

	@Autowired
	SeatService seatService;

	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {

		return seatService.saveSeat(seat);
	}
     
	@GetMapping("/fetchSeatById")
	public ResponseStructure<Seat> fetchSeatById(@RequestParam int seatId) {

		return seatService.fetchSeatById(seatId);

	}
     
	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldSeatId,@RequestBody Seat newSeat) {

		return seatService.updateSeatById(oldSeatId, newSeat);
	}

	@GetMapping("/fetchAllSeat")
	public ResponseStructure1<Seat> fetchAllSeat() {

		return seatService.fetchAllSeat();
	}

	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatId) {

		return seatService.deleteSeatById(seatId);

	}
}
