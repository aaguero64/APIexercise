package com.sierraclass.mvnNewProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sierraclass.mvnNewProject.entity.Car;
import com.sierraclass.mvnNewProject.service.CarService;

@RestController
public class CarController {
	
	//Instance of the Loger
	private static final Logger Logger = LogManager.getLogger(CarController.class);
	
	
	@Autowired  
	CarService service;
	
	//Create a new car
	@RequestMapping(value="/cars", method=RequestMethod.POST)
	public Car addCar(@RequestBody Car car) {
		return service.createCar(car);
	}
	
	//list all cars
		@RequestMapping("/cars")
		public Iterable<Car> getCars(){
			Logger.debug("Debugging log");
			Logger.info("Info Log");
			Logger.warn("Hey, this is a warning!");
			Logger.error("Oops! We have an error!");
			Logger.fatal("Something really went wrong!!!");
			return service.getCars();
		}
	
		//read a car by id
		@RequestMapping("/cars/{id}")
		public Car getCar(@PathVariable Long id){
			return service.getCar(id);
		}	
		
		//Delete a car by id
		@RequestMapping(value="/car/{id}", method=RequestMethod.DELETE)
		public void deleteCar(@PathVariable Long id) {
			service.deleteCar(id);
		}
		
		//update a friend
		@RequestMapping(value="/cars/{id}", method=RequestMethod.PUT)
		public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
			return service.updateCar(id, car);
		}

}
