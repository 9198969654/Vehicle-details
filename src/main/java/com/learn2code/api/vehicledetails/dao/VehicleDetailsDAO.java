package com.learn2code.api.vehicledetails.dao;

import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsDAO extends JpaRepository<VehicleDetail, Integer>{

}