package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Review;
import com.qsp.movie_reservation_system.service.ReviewService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@PostMapping("/saveReview")
	public ResponseStructure<Review> saveReview(@RequestBody Review review) {

		return reviewService.saveReview(review);
	}
     
	@GetMapping("/fetchReviewById")
	public ResponseStructure<Review> fetchReviewById(@RequestParam int reviewId) {

		return reviewService.fetchReviewById(reviewId);

	}
     
	@PutMapping("/updateReviewById")
	public ResponseStructure<Review> updateReviewById(@RequestParam int oldReviewId,@RequestBody Review newReview) {

		return reviewService.updateReviewById(oldReviewId, newReview);
	}

	@GetMapping("/fetchAllReview")
	public ResponseStructure1<Review> fetchAllReview() {

		return reviewService.fetchAllReview();
	}

	@DeleteMapping("/deleteReviewById")
	public ResponseStructure<Review> deleteReviewById(@RequestParam int reviewId) {

		return reviewService.deleteReviewById(reviewId);

	}
}
