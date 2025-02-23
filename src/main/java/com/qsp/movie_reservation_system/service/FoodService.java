package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.FoodDao;
import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.exceptions.FoodIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;
	
	@Autowired
	ResponseStructure1<Food> responseStructure1;
	
	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Food insterted into Database");
		responseStructure.setData(foodDao.saveFood(food));

		return responseStructure;
	}

	public ResponseStructure<Food> fetchFoodById(int foodId) {
		Food food=foodDao.fetchFoodById(foodId);
		if(food != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Food Fetched from Database");
        responseStructure.setData(foodDao.fetchFoodById(foodId));
		return responseStructure;
		}
		throw new FoodIdNotFound(); 
	}
	public ResponseStructure<Food> updateFoodById(int oldFoodId,Food newFood) {
		Food food=foodDao.fetchFoodById(oldFoodId);
		if(food != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food Updated from Database");
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
		return responseStructure ;
	}
	throw new FoodIdNotFound(); 
	}
	
	public ResponseStructure1<Food> fetchAllFood(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Foods fetched from Database");
		responseStructure1.setData(foodDao.fetchAllFood());

		return responseStructure1;
		
		
	}

	public ResponseStructure<Food> deleteFoodById(int foodId){
		Food food=foodDao.fetchFoodById(foodId);
		if(food != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food delete from Database");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return responseStructure ;
		}
		throw new FoodIdNotFound(); 
	}
		
	
}
