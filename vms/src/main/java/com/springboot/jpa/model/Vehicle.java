package com.springboot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "vehicleinfo")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	
	@NotBlank(message = "Vehicle name can not be null")
	@Column(name = "Vehicle_Name")
	private String vehicle_Name;
	
	@NotBlank(message = "Vehicle model can not be null")
	@Column(name = "Vehicle_Model")
	private String vehicle_Model;
	
	@NotBlank(message = "Vehicle year can not be null")
	@Column(name = "Vehicle_Year")
	private String vehicle_Year;
	
	@NotBlank(message = "Chassis number can not be null")
	
	@Column(name = "Chassis_Number")
	private String chassis_Number;
	
	@NotBlank(message = "Registration number can not be null")
	@Column(name = "Registration_Number")
	private String registration_Number;
	
	@NotBlank(message = "Fuel type can not be null")
	@Column(name = "Fuel_Type")
	private String fuel_Type;
	
	
	
	

	public Vehicle() {
		super();
	}
	
	

//	public Vehicle(int id, @NotBlank(message = "Vehicle name can not be null") String vehicle_Name,
//			@NotBlank(message = "Vehicle model can not be null") String vehicle_Model,
//			@NotBlank(message = "Vehicle year can not be null") String vehicle_Year,
//			@NotBlank(message = "Chassis number can not be null") String chassis_Number,
//			@NotBlank(message = "Registration number can not be null") String registration_Number,
//			@NotBlank(message = "Fuel type can not be null") String fuel_Type) {
//		super();
//		this.id = id;
//		this.vehicle_Name = vehicle_Name;
//		this.vehicle_Model = vehicle_Model;
//		this.vehicle_Year = vehicle_Year;
//		this.chassis_Number = chassis_Number;
//		this.registration_Number = registration_Number;
//		this.fuel_Type = fuel_Type;
//	}



	public Vehicle(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_Name() {
		return vehicle_Name;
	}

	public void setVehicle_Name(String vehicle_Name) {
		this.vehicle_Name = vehicle_Name;
	}

	public String getVehicle_Model() {
		return vehicle_Model;
	}

	public void setVehicle_Model(String vehicle_Model) {
		this.vehicle_Model = vehicle_Model;
	}

	public String getVehicle_Year() {
		return vehicle_Year;
	}

	public void setVehicle_Year(String vehicle_Year) {
		this.vehicle_Year = vehicle_Year;
	}

	public String getChassis_Number() {
		return chassis_Number;
	}

	public void setChassis_Number(String chassis_Number) {
		this.chassis_Number = chassis_Number;
	}

	public String getRegistration_Number() {
		return registration_Number;
	}

	public void setRegistration_Number(String registration_Number) {
		this.registration_Number = registration_Number;
	}

	public String getFuel_Type() {
		return fuel_Type;
	}

	public void setFuel_Type(String fuel_Type) {
		this.fuel_Type = fuel_Type;
	}



	@Override
	public String toString() {
		return "Vehicle [id=" + id + "]";
	}



//	@Override
//	public String toString() {
//		return "Vehicle [id=" + id + ", vehicle_Name=" + vehicle_Name + ", vehicle_Model=" + vehicle_Model
//				+ ", vehicle_Year=" + vehicle_Year + ", chassis_Number=" + chassis_Number + ", registration_Number="
//				+ registration_Number + ", fuel_Type=" + fuel_Type + "]";
//	}
//	
	
	

}
