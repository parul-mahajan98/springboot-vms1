package com.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.springboot.jpa.dto.AssignRequest;

import com.springboot.jpa.model.Driver;
import com.springboot.jpa.repository.DriverRepository;
import com.springboot.jpa.repository.VehicleRepository;

//@RestController
@Controller
public class AssignController {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	
	@PostMapping("/assign")
	public Driver assign(@RequestBody AssignRequest request) {
		return driverRepository.save(request.getDriver());
	}
	
	@GetMapping("/findAllAssigned")
	public List<Driver> findAllAssigned(){
		return driverRepository.findAll();
	}
	
//	@GetMapping("/getInfo")
//	public List<AssignResponse> getJoinInformation(){
//		return driverRepository.getJoinInformation();
//		
//	}
	@GetMapping("/getInfo")
	public String getJoinInfo(Model model) {
		model.addAttribute("assignResponse", driverRepository.getJoinInformation());
		
		return "jointable";
	}
}
