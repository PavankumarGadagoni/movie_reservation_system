package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.movie_reservation_system.dao.SeatDao;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.exceptions.SeatIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructure1<Seat> responseStructure1;
	
	public ResponseStructure<Seat> saveSeat(Seat seat) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Seat insterted into Database");
		responseStructure.setData(seatDao.saveSeat(seat));

		return responseStructure;
	}

	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		Seat dbSeat=seatDao.fetchSeatById(seatId);
		if(dbSeat != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Seat Fetched from Database");
        responseStructure.setData(seatDao.fetchSeatById(seatId));
		return responseStructure;
		
		}
		throw new SeatIdNotFound();

	}
	public ResponseStructure<Seat> updateSeatById(int oldSeatId,Seat newSeat) {
		Seat dbSeat=seatDao.fetchSeatById(oldSeatId);
		if(dbSeat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat Updated from Database");
		responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
		return responseStructure ;
		}
		throw new SeatIdNotFound();
	}
	
	public ResponseStructure1<Seat> fetchAllSeat(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Seats fetched from Database");
		responseStructure1.setData(  seatDao.fetchAllSeat());
		return responseStructure1;
		
	}

	public ResponseStructure<Seat> deleteSeatById(int seatId){
		Seat dbSeat=seatDao.fetchSeatById(seatId);
		if(dbSeat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat delete from Database");
		responseStructure.setData(seatDao.deleteSeatById(seatId));
		return responseStructure ;
		}
		throw new SeatIdNotFound();
	}
	
	
	
}
