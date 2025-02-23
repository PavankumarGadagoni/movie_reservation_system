package com.qsp.movie_reservation_system.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.movie_reservation_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {


	@Autowired
	ResponseStructure<String> responseStructure;
 	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(ownerIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(addressIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseStructure<String> branchIdNotFound(BranchIdNotFound branchIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(branchIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(foodIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseStructure<String> managerIdNotFound(ManagerIdNotFound managerIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(managerIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(MovieIdNotFound.class)
	public ResponseStructure<String> movieIdNotFound(MovieIdNotFound movieIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(movieIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(paymentIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(ReviewIdNotFound.class)
	public ResponseStructure<String> reviewIdNotFound(ReviewIdNotFound  reviewIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(reviewIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(ScreenIdNotFound.class)
	public ResponseStructure<String> screenIdNotFound(ScreenIdNotFound  screenIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(screenIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound  seatIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(seatIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(StaffIdNotFound.class)
	public ResponseStructure<String> staffIdNotFound(StaffIdNotFound  staffIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(staffIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(TheatreIdNotFound.class)
	public ResponseStructure<String> theatreIdNotFound(TheatreIdNotFound  theatreIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(theatreIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound  ticketIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(ticketIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
	@ExceptionHandler(ViewerIdNotFound.class)
	public ResponseStructure<String> viewerIdNotFound(ViewerIdNotFound  viewerIdNotFound){
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage(viewerIdNotFound.getMessage());
		 responseStructure.setData(null);
		 return responseStructure;
	}
}
