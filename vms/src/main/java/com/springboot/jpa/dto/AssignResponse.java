package com.springboot.jpa.dto;

public class AssignResponse {

	private String firstname;
	private String lastname;
	private String vehicle_Name;
	private String vehicle_Model;
	private String chassis_Number;
	
	
	
	public AssignResponse() {
		super();
	}
	public AssignResponse(String firstname, String lastname, String vehicle_Name, String vehicle_Model,
			String chassis_Number) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.vehicle_Name = vehicle_Name;
		this.vehicle_Model = vehicle_Model;
		this.chassis_Number = chassis_Number;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getChassis_Number() {
		return chassis_Number;
	}
	public void setChassis_Number(String chassis_Number) {
		this.chassis_Number = chassis_Number;
	}
	@Override
	public String toString() {
		return "AssignResponse [firstname=" + firstname + ", lastname=" + lastname + ", vehicle_Name=" + vehicle_Name
				+ ", vehicle_Model=" + vehicle_Model + ", chassis_Number=" + chassis_Number + "]";
	}
	
	
}
