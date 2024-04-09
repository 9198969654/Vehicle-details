package com.learn2code.api.vehicledetails.enteties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "* Manufacturer name is required")
    private String brandName;

    @NotBlank(message = "* Model name is required")
    @Size(min = 3, max = 15, message = "* Model name should be between 3-15 character")
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
