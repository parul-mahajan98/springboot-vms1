package com.springboot.jpa.model;



import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "driverinfo")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@NotBlank(message = "Firstname can not be null")
	@Column(name="Firstname")
	private String firstname;
	
	@NotBlank(message = "Lastname can not be null")
	@Column(name="Lastname")
	private String lastname;
	
	@NotBlank(message = "Date of Birth can not be null")
	@Column(name="Dob")
	private String dob;
	
	@NotBlank(message = "Address can not be null")
	@Column(name="Address")
	private String address;
	

	@Lob
	@Column(name="Upload_License")
	private byte[] upload_License;
	
	@NotBlank(message = "License number can not be null")
	@Column(name="License_Number")
	private String license_Number;
	
	@NotBlank(message = "License expiry date can not be null")
	@Column(name="License_Expiry_Date")
	private String license_expiry_date;
	
	@OneToMany(targetEntity=Vehicle.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="driver_id",referencedColumnName ="id")
    private List<Vehicle> vehicles;
	
	public Driver() {
		super();
	}
	
	public Driver(int id, @NotBlank(message = "Firstname can not be null") String firstname,
			@NotBlank(message = "Lastname can not be null") String lastname,
			@NotBlank(message = "Date of Birth can not be null") String dob,
			@NotBlank(message = "Address can not be null") String address, byte[] upload_License,
			@NotBlank(message = "License number can not be null") String license_Number,
			@NotBlank(message = "License expiry date can not be null") String license_expiry_date,
			List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.address = address;
		this.upload_License = upload_License;
		this.license_Number = license_Number;
		this.license_expiry_date = license_expiry_date;
		this.vehicles = vehicles;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getUpload_License() {
		return upload_License;
	}
	public void setUpload_License(byte[] upload_License) {
		this.upload_License = upload_License;
	}
	public String getLicense_Number() {
		return license_Number;
	}
	public void setLicense_Number(String license_Number) {
		this.license_Number = license_Number;
	}
	public String getLicense_expiry_date() {
		return license_expiry_date;
	}
	public void setLicense_expiry_date(String license_expiry_date) {
		this.license_expiry_date = license_expiry_date;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", address=" + address + ", upload_License=" + Arrays.toString(upload_License) + ", license_Number="
				+ license_Number + ", license_expiry_date=" + license_expiry_date + ", vehicles=" + vehicles + "]";
	}
	
	
	
}