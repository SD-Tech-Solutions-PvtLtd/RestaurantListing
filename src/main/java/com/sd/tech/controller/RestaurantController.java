package com.sd.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sd.tech.entity.Restaurant;
import com.sd.tech.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	 ResponseEntity<Restaurant> savedRestaurant;
	 List<Restaurant> allRestaurants;
	 ResponseEntity<Restaurant> restaurantById;
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant)
	{
		try
		{
			savedRestaurant = restaurantService.saveRestaurant(restaurant);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return savedRestaurant;
		
	}
	
	@GetMapping("/getAll")
	public List<Restaurant> getAllRestaurant()
	{
		try
		{
			allRestaurants = restaurantService.getAllRestaurants();
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allRestaurants;
	}
	@GetMapping("fetchById/{id}")
	public ResponseEntity<Restaurant> fecthRestaurantById(@PathVariable Integer id)
	{
		try
		{
			log.info("inside fecthRestaurantById .... "+id);
			restaurantById = restaurantService.getRestaurantById(id);
		}
		
		catch (Exception e) {
			log.info("inside Exception .... "+e.getMessage());
			System.out.println(e.getMessage());
		}
		return restaurantById ;
	}
	

}
