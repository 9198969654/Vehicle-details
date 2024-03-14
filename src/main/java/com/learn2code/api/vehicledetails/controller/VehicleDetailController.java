package com.learn2code.api.vehicledetails.controller;


import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.service.VehicleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailController {

    @Autowired
    private VehicleDetailService vehicleDetailService;

    @PostMapping
    public ResponseEntity<VehicleDetail> saveVehicleDetails(@RequestBody VehicleDetail vehicleDetail){
       VehicleDetail dbVehicle =  vehicleDetailService.saveVehicleDetails(vehicleDetail);
       return new ResponseEntity<>(dbVehicle, HttpStatus.CREATED);
    }
}
