package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.dto.AssignResponse;
import com.springboot.jpa.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>{

	@Query(value="select * from driverinfo d where d.id like %:keyword% or d.firstname like %:keyword% or d.lastname like %:keyword% or d.dob like %:keyword% or d.address like %:keyword% or d.upload_License like %:keyword% or d.license_Number like %:keyword% or d.license_expiry_date like %:keyword% or d.vehicles like %:keyword%",nativeQuery=true)
	List<Driver> findByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT new com.springboot.jpa.dto.AssignResponse( d.firstname,d.lastname,v.vehicle_Name,v.vehicle_Model,v.chassis_Number) FROM Driver d JOIN d.vehicles v")
	public List<AssignResponse> getJoinInformation();
}
