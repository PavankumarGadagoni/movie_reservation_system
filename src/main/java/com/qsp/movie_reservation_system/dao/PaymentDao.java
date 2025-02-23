package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Payment;
import com.qsp.movie_reservation_system.repo.PaymentRepo;

@Repository
public class PaymentDao {
	
	@Autowired
	PaymentRepo paymentRepo;

	public Payment savePayment(Payment payment) {

		return paymentRepo.save(payment);
	}

	public Payment fetchPaymentById(int paymentId) {
		
		Optional<Payment> dbPayment = paymentRepo.findById(paymentId);

	   if(dbPayment.isPresent()) return dbPayment.get();
	   return null;

	}
	public Payment updatePaymentById(int oldPaymentId,Payment newPayment) {
		
		newPayment.setPaymentId(oldPaymentId);
		return savePayment(newPayment);
	}
	
	public List<Payment> fetchAllPayment(){
		
		return paymentRepo.findAll();
	}

	public Payment deletePaymentById(int paymentId){
		Payment payment = fetchPaymentById(paymentId);
		paymentRepo.delete(payment);
		return payment;
	}

}
