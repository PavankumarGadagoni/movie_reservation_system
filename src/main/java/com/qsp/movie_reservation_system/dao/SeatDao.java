package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.repo.SeatRepo;

@Repository
public class SeatDao {
	
	@Autowired
	SeatRepo seatRepo;

	public Seat saveSeat(Seat seat) {

		return seatRepo.save(seat);
	}

	public Seat fetchSeatById(int seatId) {
		
		Optional<Seat> dbSeat = seatRepo.findById(seatId);

		if(dbSeat.isPresent()) return dbSeat.get();
			return null;

	}
	public Seat updateSeatById(int oldSeatId,Seat newSeat) {
		
		newSeat.setSeatId(oldSeatId);
		return saveSeat(newSeat);
	}
	
	public List<Seat> fetchAllSeat(){
		
		return seatRepo.findAll();
	}

	public Seat deleteSeatById(int seatId){
		Seat seat = fetchSeatById(seatId);
		seatRepo.delete(seat);
		return seat;
	}
	

}
