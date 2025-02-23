package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.movie_reservation_system.dao.ReviewDao;
import com.qsp.movie_reservation_system.dto.Review;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class ReviewService {

	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ResponseStructure<Review> responseStructure;
	
	@Autowired
	ResponseStructure1<Review> responseStructure1;
	
	public ResponseStructure<Review> saveReview(Review review) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Review insterted into Database");
		responseStructure.setData(reviewDao.saveReview(review));

		return responseStructure;
	}

	public ResponseStructure<Review> fetchReviewById(int reviewId) {

		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Review Fetched from Database");
		responseStructure.setData(reviewDao.fetchReviewById(reviewId));
		return responseStructure;

	}
	public ResponseStructure<Review> updateReviewById(int oldReviewId,Review newReview) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review Updated into Database");
		responseStructure.setData(reviewDao.updateReviewById(oldReviewId, newReview));
		return responseStructure;
	}
	
	public ResponseStructure1<Review> fetchAllReview(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Reviews fetched from Database");
		responseStructure1.setData(reviewDao.fetchAllReview());

		return responseStructure1;
	}

	public ResponseStructure<Review> deleteReviewById(int reviewId){
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review deleted in Database");
		responseStructure.setData(reviewDao.deleteReviewById(reviewId));
		return responseStructure;
		
	}
	
}
