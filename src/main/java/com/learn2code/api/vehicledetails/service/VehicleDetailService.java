package com.learn2code.api.vehicledetails.service;

import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.errors.VehicleNotSaved;

public interface VehicleDetailService {
    VehicleDetail saveVehicleDetails(VehicleDetail vehicleDetail) throws VehicleNotSaved;
}
