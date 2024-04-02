package com.learn2code.api.vehicledetails.dto;

import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetailsDTO {

  List<VehicleDetail> vehicleDetailList;
}
