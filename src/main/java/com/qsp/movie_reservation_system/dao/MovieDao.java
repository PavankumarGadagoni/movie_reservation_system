package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.movie_reservation_system.dto.Movie;
import com.qsp.movie_reservation_system.dto.Review;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.repo.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	MovieRepo movieRepo;

	@Autowired
	ViewerDao viewerDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	
	
	public Movie saveMovie(Movie movie) {

		return movieRepo.save(movie);
	}
	
 public Movie addExistingReviewToExistingMovie(int ReviewId,int movieId) {
		
		Review review=reviewDao.fetchReviewById(ReviewId);
		Movie movie = fetchMovieById(movieId);
		List<Review> reviews = movie.getReviews();
		reviews.add(review);
		return saveMovie(movie);
	}
	public Movie addNewReviewToExistingMovie(int movieId,Review newReview) {
		Movie movie=fetchMovieById(movieId);
		List<Review> reviews = movie.getReviews();
		reviews.add(newReview);
		return saveMovie(movie);
		
	}
	
	
	

	public Movie addExistingviewerToExistingMovie(int viewerId, int movieId) {

		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		Movie movie = fetchMovieById(movieId);
		List<Viewer> viewerList = movie.getViewers();
		viewerList.add(viewer);
		return saveMovie(movie);
	}

	public Movie addNewviewerToExistingMovie(int movieId, Viewer newviewer) {
		Movie movie = fetchMovieById(movieId);
		List<Viewer> viewerList = movie.getViewers();
		viewerList.add(newviewer);
		return saveMovie(movie);

	}

	public Movie fetchMovieById(int movieId){

		Optional<Movie> dbMovie = movieRepo.findById(movieId);
		
		if(dbMovie.isPresent()) return dbMovie.get();
           return null;
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {

		newMovie.setMovieId(oldMovieId);
		return saveMovie(newMovie);
	}

	public List<Movie> fetchAllMovie() {

		return movieRepo.findAll();
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = fetchMovieById(movieId);
		movieRepo.delete(movie);
		return movie;
	}

}
