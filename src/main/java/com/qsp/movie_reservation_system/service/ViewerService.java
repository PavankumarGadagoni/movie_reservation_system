package com.qsp.movie_reservation_system.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.FoodDao;
import com.qsp.movie_reservation_system.dao.SeatDao;
import com.qsp.movie_reservation_system.dao.TicketDao;
import com.qsp.movie_reservation_system.dao.ViewerDao;
import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.exceptions.FoodIdNotFound;
import com.qsp.movie_reservation_system.exceptions.SeatIdNotFound;
import com.qsp.movie_reservation_system.exceptions.TicketIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ViewerIdNotFound;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;
@Service
public class ViewerService {
	
	@Autowired
	ViewerDao viewerDao;
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	ResponseStructure<Viewer> responseStructure;
	
	@Autowired
	ResponseStructure1<Viewer> responseStructure1;
	
	public ResponseStructure<Viewer> saveViewer(Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Viewer insterted into Database");
		responseStructure.setData(viewerDao.saveViewer(viewer));

		return responseStructure;
	}
	
	public ResponseStructure<Viewer> addExistingTicketToExistingViewer(int ticketId,int viewerId) {
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		Ticket dbTicket =ticketDao.fetchTicketById(ticketId);
		if(dbViewer != null && dbTicket != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing ticket to Viewer");
		responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));

		return responseStructure;
		}
		else {
			if(dbTicket == null) throw new TicketIdNotFound();
			else throw new ViewerIdNotFound();
		}
	}
	
	public ResponseStructure<Viewer> addNewTicketToExistingViewer(int viewerId,Ticket newTicket) {
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		if(dbViewer != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new ticket to Viewer");
		responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));

		return responseStructure;
		}
		throw new ViewerIdNotFound();
	}
	

	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		if(dbViewer != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Viewer fetched from Database");
		responseStructure.setData(viewerDao.fetchViewerById(viewerId));

		return responseStructure;
		}
		throw new ViewerIdNotFound();

	}
	
	public ResponseStructure<Viewer> addNewFoodToExistingViewer(int viewerId,Food newFood) {
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		if(dbViewer != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new food to Viewer");
		responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId,newFood));

		return responseStructure;
		}
		throw new ViewerIdNotFound();
	}
	
	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(int foodId,int viewerId) {
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		 Food dbFood=foodDao.fetchFoodById(foodId);
		if(dbViewer != null && dbFood != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing Food to Viewer");
		responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));

		return responseStructure;
		}
		else {
			if(dbFood == null) throw new FoodIdNotFound();
			else throw new ViewerIdNotFound();
		}
	}
	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(int seatId, int viewerId){
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		Seat dbSeat=seatDao.fetchSeatById(seatId);
		if(dbViewer != null && dbSeat != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing Seat to Viewer");
		responseStructure.setData(viewerDao.addExistingSeatToExistingViewer(seatId, viewerId));

		return responseStructure;
		}
		else {
			if(dbSeat == null) throw new SeatIdNotFound();
			else throw new ViewerIdNotFound();
		}
	}
	public ResponseStructure<Viewer> updateViewerById(int oldViewerId,Viewer newViewer) {
		Viewer dbViewer = viewerDao.fetchViewerById(oldViewerId);
		if(dbViewer != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer updated into Database");
		responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));

		return responseStructure;
		}
		throw new ViewerIdNotFound();
		
	}
	
	public ResponseStructure1<Viewer> fetchAllViewer(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Viewers fetched from Database");
		responseStructure1.setData(viewerDao.fetchAllViewer());
		return responseStructure1;
	}

	public ResponseStructure<Viewer> deleteViewerById(int viewerId){
		Viewer dbViewer = viewerDao.fetchViewerById(viewerId);
		if(dbViewer != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer deleted in Database");
		responseStructure.setData(viewerDao.deleteViewerById(viewerId));

		return responseStructure;
		}
		throw new ViewerIdNotFound();
		
	}
}
