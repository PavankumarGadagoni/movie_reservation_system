package com.qsp.movie_reservation_system.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.movie_reservation_system.dao.ViewerDao;
import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;
@Service
public class ViewerService {
	
	@Autowired
	ViewerDao viewerDao;
	
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
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing ticket to Viewer");
		responseStructure.setData(viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId));

		return responseStructure;
	}
	
	public ResponseStructure<Viewer> addNewTicketToExistingViewer(int viewerId,Ticket newTicket) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new ticket to Viewer");
		responseStructure.setData(viewerDao.addNewTicketToExistingViewer(viewerId, newTicket));

		return responseStructure;
	}
	

	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Viewer fetched from Database");
		responseStructure.setData(viewerDao.fetchViewerById(viewerId));

		return responseStructure;

	}
	
	public ResponseStructure<Viewer> addNewFoodToExistingViewer(int viewerId,Food newFood) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added new food to Viewer");
		responseStructure.setData(viewerDao.addNewFoodToExistingViewer(viewerId,newFood));

		return responseStructure;
	}
	
	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(int foodId,int viewerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing Food to Viewer");
		responseStructure.setData(viewerDao.addExistingFoodToExistingViewer(foodId, viewerId));

		return responseStructure;
	}
	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(int seatId, int viewerId){
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully added existing Seat to Viewer");
		responseStructure.setData(viewerDao.addExistingSeatToExistingViewer(seatId, viewerId));

		return responseStructure;
	}
	public ResponseStructure<Viewer> updateViewerById(int oldViewerId,Viewer newViewer) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer updated into Database");
		responseStructure.setData(viewerDao.updateViewerById(oldViewerId, newViewer));

		return responseStructure;
		
	}
	
	public ResponseStructure1<Viewer> fetchAllViewer(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Viewers fetched from Database");
		responseStructure1.setData(viewerDao.fetchAllViewer());
		return responseStructure1;
	}

	public ResponseStructure<Viewer> deleteViewerById(int viewerId){
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer deleted in Database");
		responseStructure.setData(viewerDao.deleteViewerById(viewerId));

		return responseStructure;
		
	}
}
