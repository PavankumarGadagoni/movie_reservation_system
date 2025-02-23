package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Branch;
import com.qsp.movie_reservation_system.dto.Theatre;
import com.qsp.movie_reservation_system.repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);
	}
	public Theatre addNewBranchToExistingTheatre(int theatreId,Branch newBranch) {
		Theatre theatre=fetchTheatreById(theatreId);
		List<Branch> branches=theatre.getBranches();
		branches.add(newBranch);
		return saveTheatre(theatre);
		
	}
	
	public Theatre addExistingbranchToExistingTheatre(int branchId,int theatreId ){
		Branch branch=branchDao.fetchBranchById(branchId);
		Theatre theatre=fetchTheatreById(theatreId);
		List<Branch> branches=theatre.getBranches();
		branches.add(branch);
		return saveTheatre(theatre);
	}
	
	public Theatre fetchTheatreById(int theatreId) {
		
		Optional<Theatre> dbTheatre = theatreRepo.findById(theatreId);

		if(dbTheatre.isPresent()) return dbTheatre.get();
		
         return null;
	}
	public Theatre updateTheatreById(int oldTheatreId,Theatre newTheatre) {
		
		newTheatre.setTheatreId(oldTheatreId);
		
		return saveTheatre(newTheatre);
	}
	
	public List<Theatre> fetchAllTheatre(){
		
		return theatreRepo.findAll();
	}

	public Theatre deleteTheatreById(int theatreId){
		Theatre theatre = fetchTheatreById(theatreId);
		theatreRepo.delete(theatre);
		return theatre;
	}
	
}
