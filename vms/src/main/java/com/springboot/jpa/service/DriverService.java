package com.springboot.jpa.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.springboot.jpa.model.Driver;
import com.springboot.jpa.model.Vehicle;

public interface DriverService {

	List<Driver> getAllDrivers();
	void saveDriver(Driver driver);
	Driver getDriverById(int id);
	void deleteDriverById(int id);
    void saveLicenseToDB(String firstname,String lastname,String dob,String address,MultipartFile file,String license_Number,String license_expiry_date,List<Vehicle> vehicles);
	List<Driver> findByKeyword(String keyword);
	
}
