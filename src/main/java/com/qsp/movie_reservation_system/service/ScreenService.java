package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.MovieDao;
import com.qsp.movie_reservation_system.dao.ScreenDao;
import com.qsp.movie_reservation_system.dao.SeatDao;
import com.qsp.movie_reservation_system.dto.Movie;
import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.exceptions.MovieIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ScreenIdNotFound;
import com.qsp.movie_reservation_system.exceptions.SeatIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class ScreenService {

	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	ResponseStructure<Screen> responseStructure;
	
	@Autowired
	ResponseStructure1<Screen> responseStructure1;
	
	@Autowired
	SeatDao  seatDao;
	
	@Autowired
	MovieDao movieDao;

	public ResponseStructure<Screen> saveScreen(Screen screen) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully screen inserted into Database");
		responseStructure.setData(screenDao.saveScreen(screen));
		return responseStructure;
	}
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(int seatId,int screenId ) {
		Seat existingSeat = seatDao.fetchSeatById(seatId);
		Screen existingScreen=screenDao.fetchScreenById(screenId);
		if(existingScreen != null && existingSeat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing seat to screen");
		responseStructure.setData(screenDao.addExistingSeatToExistingScreen(seatId, screenId));
		return responseStructure;
		}
		else {
			if(existingSeat == null) throw new SeatIdNotFound();		
			else throw new ScreenIdNotFound();	
		}
	}
	
	public ResponseStructure<Screen> addNewSeatToExistingScreen(int screenId,Seat newSeat) {
		Screen existingScreen=screenDao.fetchScreenById(screenId);
		if(existingScreen != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new seat to screen");
		responseStructure.setData(screenDao.addNewSeatToExistingScreen(screenId, newSeat));
		return responseStructure;
		}
		throw new ScreenIdNotFound();
	}
	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		Screen existingScreen=screenDao.fetchScreenById(screenId);
		if(existingScreen != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully screen fetched from Database");
		responseStructure.setData(screenDao.fetchScreenById(screenId));
		return responseStructure;
		}
		throw new ScreenIdNotFound();

	}

	public ResponseStructure<Screen> addExistingMovieToExistingScreen(int movieId, int screenId) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);
		Screen existingScreen=screenDao.fetchScreenById(screenId);
		if(existingScreen != null && existingScreen != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing movie to screen");
		responseStructure.setData(screenDao.addExistingMovieToExistingScreen(movieId, screenId));
		return responseStructure;
		}
		else {
			if(existingMovie == null) throw new MovieIdNotFound();		
			else throw new ScreenIdNotFound();	
		}
		
	}
	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen newScreen) {
		Screen existingScreen=screenDao.fetchScreenById(oldScreenId);
		if(existingScreen != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully screen updated into Database");
		responseStructure.setData(screenDao.updateScreenById(oldScreenId, newScreen));
		return responseStructure;
		}
		throw new ScreenIdNotFound();
	}

	public ResponseStructure1<Screen> fetchAllScreen() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Screens fetched from Database");
		responseStructure1.setData( screenDao.fetchAllScreen());
		return responseStructure1;
	}

	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		Screen existingScreen=screenDao.fetchScreenById(screenId);
		if(existingScreen != null) {
		
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully screen updated into Database");
		responseStructure.setData(screenDao.deleteScreenById(screenId));
		return responseStructure;
		}
		throw new ScreenIdNotFound();
	}

}
