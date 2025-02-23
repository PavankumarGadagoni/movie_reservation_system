package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Movie;
import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.repo.ScreenRepo;

@Repository
public class ScreenDao {
	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	MovieDao movieDao;

	@Autowired
	SeatDao seatDao;

	public Screen saveScreen(Screen screen) {

		return screenRepo.save(screen);
	}

	public Screen addExistingSeatToExistingScreen(int seatId, int screenId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Screen screen = fetchScreenById(screenId);
		List<Seat> seats = screen.getSeats();
		seats.add(seat);
		return saveScreen(screen);
	}

	public Screen addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		Screen screen = fetchScreenById(screenId);
		List<Seat> seats = screen.getSeats();
		seats.add(newSeat);
		return saveScreen(screen);

	}

	public Screen fetchScreenById(int screenId) {

		Optional<Screen> dbScreen = screenRepo.findById(screenId);
		if (dbScreen.isPresent())
			return dbScreen.get();
		return null;

	}

	public Screen addExistingMovieToExistingScreen(int movieId, int screenId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		Screen screen = fetchScreenById(screenId);
		screen.setMovie(movie);
		return saveScreen(screen);
	}

	public Screen updateScreenById(int oldScreenId, Screen newScreen) {

		newScreen.setScreenId(oldScreenId);
		return saveScreen(newScreen);
	}

	public List<Screen> fetchAllScreen() {

		return screenRepo.findAll();
	}

	public Screen deleteScreenById(int screenId) {
		Screen screen = fetchScreenById(screenId);
		screenRepo.delete(screen);
		return screen;
	}
}