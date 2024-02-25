package com.sd.tech.service;

import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.sd.tech.entity.Restaurant;
import com.sd.tech.repo.RestaurantRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepo restaurantRepo;

	@Override
	public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant) {
		if(restaurant!=null)
		{
			 Restaurant savedRestaurant = restaurantRepo.saveAndFlush(restaurant);
			 return new ResponseEntity<>(savedRestaurant, org.springframework.http.HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, org.springframework.http.HttpStatus.BAD_REQUEST);
		}
	 
	}

	@Override
	public ResponseEntity<Restaurant> getRestaurantById(Integer id) {
		
			 Optional<Restaurant> findById = restaurantRepo.findById(id);
			 Restaurant restaurant = findById.get();
			 if(restaurant!=null)
			 {
				 return new ResponseEntity<>(restaurant, org.springframework.http.HttpStatus.OK); 
			 }
			 else
			 {
				 return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
 
			 }
		
	}

	@Override
	public  List<Restaurant> getAllRestaurants() {
		return restaurantRepo.findAll();
		
		

		 
	}

}
