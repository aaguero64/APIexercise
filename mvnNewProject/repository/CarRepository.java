package com.sierraclass.mvnNewProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.sierraclass.mvnNewProject.entity.Car;

//Access to the entity "Car" and to the id "Long". CurdRepository take care off 
//all the CRUD operation in the database
public interface CarRepository extends CrudRepository<Car, Long>{

}
