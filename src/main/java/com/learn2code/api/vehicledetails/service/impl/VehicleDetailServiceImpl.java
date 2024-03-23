package com.learn2code.api.vehicledetails.service.impl;

import com.learn2code.api.vehicledetails.dao.VehicleDetailsDAO;
import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.errors.VehicleNotSaved;
import com.learn2code.api.vehicledetails.service.VehicleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDetailServiceImpl implements VehicleDetailService {

    @Autowired
    private VehicleDetailsDAO vehicleDetailsDAO;

    @Override
    public VehicleDetail saveVehicleDetails(VehicleDetail vehicleDetail) throws VehicleNotSaved {
        VehicleDetail dbDetails = null;
        try {
         dbDetails =    vehicleDetailsDAO.save(vehicleDetail);
        }catch (Exception ex){
            throw new VehicleNotSaved("Unable to save vehicle in DB, Got Error: " +ex.getMessage());
        }
       return vehicleDetailsDAO.save(vehicleDetail);

    }
}
