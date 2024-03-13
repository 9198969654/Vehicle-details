package com.learn2code.api.vehicledetails.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle_details")
public class VehicleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_year")
    private String modelYear;
    private String brandName;
    private String modelName;
    private String trimType;
    private String bodyType;
    private double price;
    private int miles;
    private double interestRate;
    private String location;

    @Column(name = "vehicle_description")
    private String description;

    @Column(name = "seller_name")
    private String seller;
    private String sellerPhone;


}
