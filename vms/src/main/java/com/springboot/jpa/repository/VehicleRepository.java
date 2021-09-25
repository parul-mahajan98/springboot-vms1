package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Query(value="select * from vehicleinfo v where v.id like %:keyword% or v.vehicle_Name like %:keyword% or v.vehicle_Model like %:keyword% or v.vehicle_Year like %:keyword% or v.chassis_Number like %:keyword% or v.registration_Number like %:keyword% or v.fuel_Type like %:keyword%",nativeQuery=true)
	List<Vehicle> findByKeyword(@Param("keyword") String keyword);
	
   
}
