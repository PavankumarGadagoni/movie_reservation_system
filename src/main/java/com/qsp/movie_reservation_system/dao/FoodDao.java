package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.repo.FoodRepo;

@Repository
public class FoodDao {

	@Autowired
	FoodRepo foodRepo;

	public Food saveFood(Food food) {

		return foodRepo.save(food);
	}

	public Food fetchFoodById(int foodId) {
		
		Optional<Food> dbFood = foodRepo.findById(foodId);

		if(dbFood.isPresent()) return dbFood.get();
        return null;
	}
	public Food updateFoodById(int oldFoodId,Food newFood) {
		
		newFood.setFoodId(oldFoodId);
		return saveFood(newFood);
	}
	
	public List<Food> fetchAllFood(){
		
		return foodRepo.findAll();
	}

	public Food deleteFoodById(int foodId){
		Food food = fetchFoodById(foodId);
		foodRepo.delete(food);
		return food;
	}
	
}
