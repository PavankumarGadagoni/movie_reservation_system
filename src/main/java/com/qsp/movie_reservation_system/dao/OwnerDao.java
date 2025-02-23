package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Owner;
import com.qsp.movie_reservation_system.dto.Theatre;
import com.qsp.movie_reservation_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	TheatreDao theatredao;

	public Owner saveOwner(Owner owner) {

		return ownerRepo.save(owner);
	}

	public Owner addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		
		Theatre theatre = theatredao.fetchTheatreById(theatreId);
		Owner owner = fetchOwnerById(ownerId);
        owner.setTheatre(theatre);
        return saveOwner(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		
		Optional<Owner> dbOwner = ownerRepo.findById(ownerId);

		if(dbOwner.isPresent()) return dbOwner.get();
		return null;
	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {

		newOwner.setOwnerId(oldOwnerId);
		return saveOwner(newOwner);
	}

	public List<Owner> fetchAllOwner() {

		return ownerRepo.findAll();
	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

}
