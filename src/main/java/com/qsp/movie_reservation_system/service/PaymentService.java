package com.qsp.movie_reservation_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.PaymentDao;

import com.qsp.movie_reservation_system.dto.Payment;
import com.qsp.movie_reservation_system.exceptions.PaymentIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ResponseStructure<Payment> responseStructure;
	
	@Autowired
	ResponseStructure1<Payment> responseStructure1;
	
	public ResponseStructure<Payment> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully payment insterted into Database");
		responseStructure.setData(paymentDao.savePayment(payment));

		return responseStructure;
	}

	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {

		Payment payment=paymentDao.fetchPaymentById(paymentId);
		if(payment != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully payment Fetched from Database");
		responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
		return responseStructure;
		}
		throw new PaymentIdNotFound();

	}
	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId,Payment newPayment) {
		Payment payment=paymentDao.fetchPaymentById(oldPaymentId);
		if(payment != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully payment Updated into Database");
		responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
		return responseStructure;
		}
		throw new PaymentIdNotFound();
	}
	
	public ResponseStructure1<Payment> fetchAllPayment(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Payments fetched from Database");
		responseStructure1.setData(paymentDao.fetchAllPayment());

		return responseStructure1;
	
	}

	public ResponseStructure<Payment> deletePaymentById(int paymentId){
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		if(payment != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully payment deleted in Database");
		responseStructure.setData(paymentDao.deletePaymentById(paymentId));
		return responseStructure;
		}
		throw new PaymentIdNotFound();
		
	}
}
