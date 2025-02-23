package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.service.ScreenService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class ScreenController {

	@Autowired
	ScreenService screenService;

	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {

		return screenService.saveScreen(screen);
	}

	@GetMapping("/fetchScreenById")
	public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {

		return screenService.fetchScreenById(screenId);

	}
	
	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(@RequestParam int seatId,@RequestParam int screenId ) {
		return screenService.addExistingSeatToExistingScreen(seatId, screenId);
	}
	
	@PutMapping("/addNewSeatToExistingScreen")
	public ResponseStructure<Screen> addNewSeatToExistingScreen(@RequestParam int screenId,@RequestBody Seat newSeat) {
		return screenService.addNewSeatToExistingScreen(screenId, newSeat);
	}

	@PutMapping("/addExistingMovieToExistingScreen")
	public ResponseStructure<Screen> addExistingMovieToExistingScreen(@RequestParam int movieId, @RequestParam int screenId) {

		return screenService.addExistingMovieToExistingScreen(movieId, screenId);
	}

	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreenId, @RequestBody Screen newScreen) {

		return screenService.updateScreenById(oldScreenId, newScreen);
	}

	@GetMapping("/fetchAllScreen")
	public ResponseStructure1<Screen> fetchAllScreen() {

		return screenService.fetchAllScreen();
	}

	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {

		return screenService.deleteScreenById(screenId);

	}
}
