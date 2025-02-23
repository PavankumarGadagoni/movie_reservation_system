package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Owner;
import com.qsp.movie_reservation_system.service.OwnerService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
		

		return ownerService.saveOwner(owner);
	}
     
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {

		return ownerService.fetchOwnerById(ownerId);

	}
	
	@PutMapping("/addExistingTheatreToExistingOwner")
	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(@RequestParam int theatreId,@RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
     
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {

		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@GetMapping("/fetchAllOwner")
	public ResponseStructure1<Owner> fetchAllOwner() {

		return ownerService.fetchAllOwner();
	}

	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {

		return ownerService.deleteOwnerById(ownerId);

	}
}
