package com.qsp.movie_reservation_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int foodId;
	private String foodName;
	private String foodType;
	private double foodPrice;
	private String foodQuantity;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(String foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	
	
	
}
