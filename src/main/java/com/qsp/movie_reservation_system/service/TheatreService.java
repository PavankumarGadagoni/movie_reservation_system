package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.BranchDao;
import com.qsp.movie_reservation_system.dao.TheatreDao;
import com.qsp.movie_reservation_system.dto.Branch;
import com.qsp.movie_reservation_system.dto.Theatre;
import com.qsp.movie_reservation_system.exceptions.BranchIdNotFound;
import com.qsp.movie_reservation_system.exceptions.TheatreIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class TheatreService {

	@Autowired
	TheatreDao theatreDao;

	@Autowired
	ResponseStructure<Theatre> responseStructure;
	
	@Autowired
	ResponseStructure1<Theatre> responseStructure1;
	
	@Autowired 
	BranchDao branchDao;
	
	public ResponseStructure<Theatre> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Theatre insterted into Database");
		responseStructure.setData(theatreDao.saveTheatre(theatre));

		return responseStructure;
	}

	public ResponseStructure<Theatre> fetchTheatreById(int theatreId) {
		Theatre dbTheatre =theatreDao.fetchTheatreById(theatreId);
		if(dbTheatre != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Theatre Fetched from Database");
        responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
		return responseStructure;
		
		}
		throw new TheatreIdNotFound();

	}
	public ResponseStructure<Theatre> updateTheatreById(int oldTheatreId,Theatre newTheatre) {
		Theatre dbTheatre =theatreDao.fetchTheatreById(oldTheatreId);
		if(dbTheatre != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre Updated from Database");
		responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
		return responseStructure ;
		}
		throw new TheatreIdNotFound();
	}
	
	public ResponseStructure1<Theatre> fetchAllTheatre(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Theatres fetched from Database");
		responseStructure1.setData(theatreDao.fetchAllTheatre());
		return responseStructure1;
		
	}

	public ResponseStructure<Theatre> deleteTheatreById(int theatreId){
		Theatre dbTheatre =theatreDao.fetchTheatreById(theatreId);
		if(dbTheatre != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre delete from Database");
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
		return responseStructure ;
		}
		throw new TheatreIdNotFound();
		
	}
	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(int theatreId,Branch newBranch) {
		Theatre dbTheatre =theatreDao.fetchTheatreById(theatreId);
		if(dbTheatre != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new branch to Theatre");
		responseStructure.setData(theatreDao.addExistingbranchToExistingTheatre(theatreId, theatreId));
		return responseStructure ;
		}
		throw new TheatreIdNotFound();
	}

	public ResponseStructure<Theatre> addExistingbranchToExistingTheatre(int branchId, int theatreId) {
		
		Theatre dbTheatre =theatreDao.fetchTheatreById(theatreId);
		Branch dbBranch=branchDao.fetchBranchById(branchId);
		if(dbTheatre != null && dbBranch != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing branch to Theatre");
		responseStructure.setData(theatreDao.addExistingbranchToExistingTheatre(branchId, theatreId));
		return responseStructure ;
	}
		else {
			if(dbTheatre == null) throw new TheatreIdNotFound();
			else throw new BranchIdNotFound();
		}

	
}
}
