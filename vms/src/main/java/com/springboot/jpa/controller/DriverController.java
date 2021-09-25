package com.springboot.jpa.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.springboot.jpa.model.Driver;
import com.springboot.jpa.model.Vehicle;
import com.springboot.jpa.service.DriverService;


@Controller
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	
	@GetMapping("/")
	public String openlandingpage() {
		return "index";
	}
	
	//display list of vehicles
	@GetMapping("/driver")
public String viewHomePage(Model model, String keyword) {
		

		if(keyword != null) {
			model.addAttribute("listDrivers",driverService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("listDrivers", driverService.getAllDrivers());
		}
		return "driver/list";
	}
	
	@PostMapping("/upload")
	public String saveDriver(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("dob") String dob,
			@RequestParam("address") String address,
			@RequestParam("file") MultipartFile file,
			@RequestParam("license_Number") String license_Number,
			@RequestParam("license_expiry_date") String license_expiry_date,
			@RequestParam("vehicles") List<Vehicle> vehicles
			) {
		driverService.saveLicenseToDB(firstname,lastname,dob,address,file,license_Number,license_expiry_date,vehicles);
		return "redirect:/driver";
	}
	
	@GetMapping("/showNewDriverForm")
	public String showNewDriverForm(Model model) {
		Driver driver = new Driver();
		model.addAttribute("driver",driver);
	
		
		return "driver/new";
	}
	
	@PostMapping("/saveDriver")
	public String saveDriver(@Valid @ModelAttribute("driver") Driver driver, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "driver/new";
		}
		
		
		driverService.saveDriver(driver);
		return "redirect:/driver";
	}
	
	@GetMapping("/showFormForUpdateDriver/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		Driver driver=driverService.getDriverById(id);
		model.addAttribute("driver",driver);
		return "driver/update";
	}
	
	@GetMapping("/deleteDriver/{id}")
	public String deleteDriver(@PathVariable(value = "id") int id) {
		this.driverService.deleteDriverById(id);
		return "redirect:/driver";
	}
	
	
	
}
