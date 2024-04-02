package com.learn2code.api.vehicledetails.controller;


import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.errors.MandatoryFieldMissingException;
import com.learn2code.api.vehicledetails.errors.VehicleDetailsNotFound;
import com.learn2code.api.vehicledetails.errors.VehicleNotSaved;
import com.learn2code.api.vehicledetails.service.VehicleDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailController {

    @Autowired
    private VehicleDetailService vehicleDetailService;

    @PostMapping
    public ResponseEntity<VehicleDetail> saveVehicleDetails(@Valid @RequestBody VehicleDetail vehicleDetail, BindingResult result) throws MandatoryFieldMissingException, VehicleNotSaved {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            String allErrors = "";
            for (ObjectError err  : errorList){
                allErrors += err.getDefaultMessage()+",";
            }
            throw new MandatoryFieldMissingException(allErrors);
        }
       VehicleDetail dbVehicle =  vehicleDetailService.saveVehicleDetails(vehicleDetail);
       return new ResponseEntity<>(dbVehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public List<VehicleDetail> getAllVehicleDetails() throws VehicleDetailsNotFound {
       return vehicleDetailService.fetchAllVehicleDetails();
    }


}


















