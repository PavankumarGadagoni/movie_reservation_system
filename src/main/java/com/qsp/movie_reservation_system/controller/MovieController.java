package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Movie;
import com.qsp.movie_reservation_system.dto.Review;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.service.MovieService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {

		return movieService.saveMovie(movie);
	}
	
	@PutMapping("/addExistingReviewToExistingMovie")
	public ResponseStructure<Movie> addExistingReviewToExistingMovie(@RequestParam int reviewId,@RequestParam int movieId) {

		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
	}
     
	@PutMapping("/addNewReviewToExistingMovie")
	public ResponseStructure<Movie> addNewReviewToExistingMovie(@RequestParam int movieId,@RequestBody Review newReview) {

		return movieService.addNewReviewToExistingMovie(movieId, newReview);

	}
	
	@PutMapping("/addExistingviewerToExistingMovie")
	public ResponseStructure<Movie> addExistingviewerToExistingMovie(@RequestParam int viewerId,@RequestParam int movieId) {
		return movieService.addExistingviewerToExistingMovie(viewerId, movieId);
	}

	@PutMapping("/addNewviewerToExistingMovie")
	public ResponseStructure<Movie> addNewviewerToExistingMovie(@RequestParam int movieId,@RequestBody Viewer newviewer) {
		return movieService.addNewviewerToExistingMovie(movieId, newviewer);
	}
     
	@GetMapping("/fetchMovieById")
	public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {

		return movieService.fetchMovieById(movieId);

	}
     
	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie newMovie) {

		return movieService.updateMovieById(oldMovieId, newMovie);
	}

	@GetMapping("/fetchAllMovie")
	public ResponseStructure1<Movie> fetchAllMovie() {

		return movieService.fetchAllMovie();
	}

	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {

		return movieService.deleteMovieById(movieId);

	}
}
