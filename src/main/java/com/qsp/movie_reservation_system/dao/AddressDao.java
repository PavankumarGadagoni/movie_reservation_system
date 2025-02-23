package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Address;
import com.qsp.movie_reservation_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {

		return addressRepo.save(address);
	}

	public Address fetchAddressById(int addressId) {
		
		Optional<Address> dbAddress = addressRepo.findById(addressId);

		if(dbAddress.isPresent()) {
			return dbAddress.get();
		}
		return null;

	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		
		newAddress.setAddressId(oldAddressId);
		return saveAddress(newAddress);
	}
	
	public List<Address> fetchAllAddress(){
		
		return addressRepo.findAll();
	}

	public Address deleteAddressById(int addressId){
		Address address = fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
}
