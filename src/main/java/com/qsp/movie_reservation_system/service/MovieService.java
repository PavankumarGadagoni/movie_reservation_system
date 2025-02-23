package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.MovieDao;
import com.qsp.movie_reservation_system.dao.ReviewDao;
import com.qsp.movie_reservation_system.dao.ViewerDao;
import com.qsp.movie_reservation_system.dto.Movie;
import com.qsp.movie_reservation_system.dto.Review;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.exceptions.MovieIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ReviewIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ViewerIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;

	@Autowired
	ViewerDao viewerDao;

	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ResponseStructure<Movie> responseStructure;

	@Autowired
	ResponseStructure1<Movie> responseStructure1;

	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully movie inserted into Database");
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;
	}

	public ResponseStructure<Movie> addExistingviewerToExistingMovie(int viewerId, int movieId) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);
		Viewer existingViewer = viewerDao.fetchViewerById(viewerId);
		if (existingMovie != null && existingViewer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed viwer to movie");
			responseStructure.setData(movieDao.addExistingviewerToExistingMovie(viewerId, movieId));

			return responseStructure;
		} else {
			if (existingViewer == null)
				throw new ViewerIdNotFound();
			else
				throw new MovieIdNotFound();
		}

	}

	public ResponseStructure<Movie> addExistingReviewToExistingMovie(int reviewId, int movieId) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);
		Review existngReview = reviewDao.fetchReviewById(reviewId);

		if (existngReview != null && existingMovie != null) {

			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed review to movie");
			responseStructure.setData(movieDao.addExistingReviewToExistingMovie(reviewId, movieId));

			return responseStructure;
		} else {
			if (existngReview == null)
				throw new ReviewIdNotFound();
			else
				throw new MovieIdNotFound();
		}
	}

	public ResponseStructure<Movie> addNewReviewToExistingMovie(int movieId, Review newReview) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);

		if (existingMovie != null) {

			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new review to movie");
			responseStructure.setData(movieDao.addNewReviewToExistingMovie(movieId, newReview));

			return responseStructure;
		}
		throw new MovieIdNotFound();

	}

	public ResponseStructure<Movie> addNewviewerToExistingMovie(int movieId, Viewer newviewer) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);

		if (existingMovie != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new viewer to movie");
			responseStructure.setData(movieDao.addNewviewerToExistingMovie(movieId, newviewer));
			return responseStructure;
		}
		throw new MovieIdNotFound();
	}

	public ResponseStructure<Movie> fetchMovieById(int movieId) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);

		if (existingMovie != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Movie fetched from Database");
			responseStructure.setData(movieDao.fetchMovieById(movieId));
			return responseStructure;
		}
			throw new MovieIdNotFound();
		}

	

	public ResponseStructure<Movie> updateMovieById(int oldMovieId, Movie newMovie) {
		Movie existingMovie = movieDao.fetchMovieById(oldMovieId);

		if (existingMovie != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully movie updated into Database");
		responseStructure.setData(movieDao.updateMovieById(oldMovieId, newMovie));
		return responseStructure;
	}
	throw new MovieIdNotFound();
	}

	public ResponseStructure1<Movie> fetchAllMovie() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Movies fetched from Database");
		responseStructure1.setData(movieDao.fetchAllMovie());

		return responseStructure1;
	}

	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		Movie existingMovie = movieDao.fetchMovieById(movieId);

		if (existingMovie != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully movie deleted from Database");
		responseStructure.setData(movieDao.deleteMovieById(movieId));
		return responseStructure;
		}
		throw new MovieIdNotFound();

	}
}
