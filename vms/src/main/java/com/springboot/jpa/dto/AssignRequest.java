package com.springboot.jpa.dto;

import com.springboot.jpa.model.Driver;

public class AssignRequest {

	private Driver driver;

	
	
	public AssignRequest() {
		super();
	}



	public AssignRequest(Driver driver) {
		super();
		this.driver = driver;
	}



	public Driver getDriver() {
		return driver;
	}



	public void setDriver(Driver driver) {
		this.driver = driver;
	}



	@Override
	public String toString() {
		return "AssignRequest [driver=" + driver + "]";
	}
	
	
}
