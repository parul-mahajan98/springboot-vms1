package com.springboot.jpa.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.springboot.jpa.model.Vehicle;
import com.springboot.jpa.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	
	
	//display list of vehicles
	@GetMapping("/vehicle")
public String viewHomePage(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("listVehicles",vehicleService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("listVehicles", vehicleService.getAllVehicles());
		}
		return "vehicle/list";
	}
	

	
	@GetMapping("/showNewVehicleForm")
	public String showNewVehicleForm(Model model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle",vehicle);
		return "vehicle/new";
	}
	
	@PostMapping("/saveVehicle")
	public String saveVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "vehicle/new";
		}
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicle";
	}
	
	@GetMapping("/showFormForUpdateVehicle/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		Vehicle vehicle=vehicleService.getVehicleById(id);
		model.addAttribute("vehicle",vehicle);
		return "vehicle/update";
	}
	
	@GetMapping("/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable(value = "id") int id) {
		this.vehicleService.deleteVehicleById(id);
		return "redirect:/vehicle";
	}
	
	
	
//	@RequestMapping(value = "/vehicleByYear", method = RequestMethod.POST)
//	public String findByVehicle_Year(@ModelAttribute(value = "vehicle") Vehicle vehicle, Model model) {
//	   
//	    vehicle.getVehicle_Year(); // to get option value
//
//	    return "redirect:/vehicle";
//	}


}
