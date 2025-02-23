package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.OwnerDao;
import com.qsp.movie_reservation_system.dto.Owner;
import com.qsp.movie_reservation_system.exceptions.OwnerIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	@Autowired
	ResponseStructure1<Owner> responseStructure1;
	
	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner Insterted into Database");
		responseStructure.setData(ownerDao.saveOwner(owner));

		return responseStructure;
	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner =ownerDao.fetchOwnerById(ownerId);
		if(owner != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Owner fetched from Database");
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return responseStructure;
		}
		throw new OwnerIdNotFound();

	}
	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing theatre to Owner");
		responseStructure.setData(ownerDao.addExistingTheatreToExistingOwner(theatreId, ownerId));

		return responseStructure;
	}
	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId,Owner newOwner) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner updated into Database");
		responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));

		return responseStructure;
	}
	
	public ResponseStructure1<Owner> fetchAllOwner(){
		
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All owners fetched from Database");
		responseStructure1.setData(ownerDao.fetchAllOwner());

		return responseStructure1;
		
	}

	public ResponseStructure<Owner> deleteOwnerById(int ownerId){
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner deleted into Database");
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));

		return responseStructure;
		}
		throw new OwnerIdNotFound();
		
	}
	
}
