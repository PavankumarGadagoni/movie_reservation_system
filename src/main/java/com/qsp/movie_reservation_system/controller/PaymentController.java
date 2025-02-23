package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Payment;
import com.qsp.movie_reservation_system.service.PaymentService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {

		return paymentService.savePayment(payment);
	}
     
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentId) {

		return paymentService.fetchPaymentById(paymentId);

	}
     
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {

		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}

	@GetMapping("/fetchAllPayment")
	public ResponseStructure1<Payment> fetchAllPayment() {

		return paymentService.fetchAllPayment();
	}

	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {

		return paymentService.deletePaymentById(paymentId);

	}
}
