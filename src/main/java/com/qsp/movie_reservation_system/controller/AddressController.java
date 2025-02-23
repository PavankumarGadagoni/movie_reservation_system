package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Address;
import com.qsp.movie_reservation_system.service.AddressService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {

		return addressService.saveAddress(address);
	}
     
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int addressId) {

		return addressService.fetchAddressById(addressId);

	}
     
	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {

		return addressService.updateAddressById(oldAddressId, newAddress);
	}

	@GetMapping("/fetchAllAddress")
	public ResponseStructure1<Address> fetchAllAddress() {

		return addressService.fetchAllAddress();
	}

	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {

		return addressService.deleteAddressById(addressId);

	}
}
