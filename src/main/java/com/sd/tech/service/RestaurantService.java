package com.sd.tech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sd.tech.entity.Restaurant;

public interface RestaurantService {
	
	 ResponseEntity<Restaurant>  saveRestaurant(Restaurant restaurant);
	 ResponseEntity<Restaurant> getRestaurantById(Integer id);
	 List<Restaurant>  getAllRestaurants();


}
