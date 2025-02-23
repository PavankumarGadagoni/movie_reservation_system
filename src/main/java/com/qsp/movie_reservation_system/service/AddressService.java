package com.qsp.movie_reservation_system.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.AddressDao;
import com.qsp.movie_reservation_system.dto.Address;
import com.qsp.movie_reservation_system.exceptions.AddressIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class AddressService {

	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructure1<Address> responseStructure1;
	
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address insterted into Database");
		responseStructure.setData(addressDao.saveAddress(address));

		return responseStructure;

	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Address Fetched from Database");
		responseStructure.setData(addressDao.fetchAddressById(addressId));

		return responseStructure;
		}
		throw new AddressIdNotFound();
	}
	public ResponseStructure<Address> updateAddressById(int oldAddressId,Address newAddress) {
		Address address=addressDao.fetchAddressById(oldAddressId);
		if(address != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address updated into Database");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));

		return responseStructure;
		}
	 throw new AddressIdNotFound();
	}
	
	public ResponseStructure1<Address> fetchAllAddress(){
		
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Address fetched from Database");
		responseStructure1.setData(addressDao.fetchAllAddress());

		return responseStructure1;
		
	}

	public ResponseStructure<Address> deleteAddressById(int addressId){
		
		Address address=addressDao.fetchAddressById(addressId);
		if(address != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address Deleted from Database");
		responseStructure.setData(addressDao.deleteAddressById(addressId));

		return responseStructure;
		}
		throw new AddressIdNotFound();
		
	}
}
