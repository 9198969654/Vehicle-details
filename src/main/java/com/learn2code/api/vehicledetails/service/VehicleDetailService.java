package com.learn2code.api.vehicledetails.service;

import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.errors.VehicleDetailsNotFound;
import com.learn2code.api.vehicledetails.errors.VehicleNotSaved;

import java.util.List;

public interface VehicleDetailService {


    VehicleDetail saveVehicleDetails(VehicleDetail vehicleDetail) throws VehicleNotSaved;
    List<VehicleDetail> fetchAllVehicleDetails() throws VehicleDetailsNotFound;
}
//