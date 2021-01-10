package com.sierraclass.mvnNewProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierraclass.mvnNewProject.entity.Car;
import com.sierraclass.mvnNewProject.repository.CarRepository;


@Service
public class CarService {
	
	//Access to the repository to connect to the DAtabase
	@Autowired 
	CarRepository repo;
	
	//set the CREATE a car
	public Car createCar(Car car) {
		return repo.save(car);
	}
	
	// set the GET one car by id
	public Car getCar(Long id) {
		return repo.findOne(id);
	}
	
	//set the GET all the cars
	public Iterable<Car> getCars(){
		return repo.findAll();
	}

	//set the DELETE a car by id
	public void deleteCar(Long id) {
		repo.delete(id);
	}
	
	//set the UPDATE a car
	public Car updateCar(Long id, Car car) {
		Car foundCar = repo.findOne(id);
		if (foundCar != null) {
			foundCar.setCarMake(car.getCarMake());
			foundCar.setCarModel(car.getCarModel());
			foundCar.setCarYear(car.getCarYear());
			foundCar.setCarMiles(car.getCarMiles());
			repo.save(foundCar);
		}
		return foundCar;
	}
	
	
}
