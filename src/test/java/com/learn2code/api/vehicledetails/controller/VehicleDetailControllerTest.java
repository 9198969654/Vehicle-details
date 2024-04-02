package com.learn2code.api.vehicledetails.controller;

import com.learn2code.api.vehicledetails.enteties.VehicleDetail;
import com.learn2code.api.vehicledetails.errors.VehicleDetailsNotFound;
import com.learn2code.api.vehicledetails.service.VehicleDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(VehicleDetailController.class)
class VehicleDetailControllerTest {

    @MockBean
    private VehicleDetailService vehicleDetailService;

    @Autowired
    private MockMvc mockMvc;

   private VehicleDetail output;

    @BeforeEach
    void setUp() {
        output = new VehicleDetail();
        output.setBrandName("Honda");
        output.setModelYear("2021");
        output.setModelName("Accord");
        output.setTrimType("LS");
        output.setBodyType("coupe");
        output.setMiles(1200);
        output.setPrice(25236.75);
        output.setInterestRate(6.75);
        output.setLocation("Seattle, WA");
        output.setDescription("Nice and clean car excellent milaze :: ");
        output.setSeller("Amazing Auto");
        output.setSellerPhone("111-123-1234");
    }

    @Test
    @DisplayName("Test save vehicle details controller end points")
    void saveVehicleDetails() throws Exception {
        VehicleDetail  input = new VehicleDetail();
        input.setBrandName("Honda");
        input.setModelYear("2021");
        input.setModelName("Accord");
        input.setTrimType("LS");
        input.setBodyType("coupe");
        input.setMiles(1200);
        input.setPrice(25236.75);
        input.setInterestRate(6.75);
        input.setLocation("Seattle, WA");
        input.setDescription("Nice and clean car excellent milaze : ");
        input.setSeller("Amazing Auto");
        input.setSellerPhone("111-123-1234");

        Mockito.when(vehicleDetailService.saveVehicleDetails(input)).thenReturn(output);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/vehicle-details")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"modelYear\": \"2021\",\n" +
                                "  \"brandName\": \"Honda\",\n" +
                                "  \"modelName\": \"Accord\",\n" +
                                "  \"trimType\": \"LS\",\n" +
                                "  \"bodyType\": \"\",\n" +
                                "  \"price\": 25236.75,\n" +
                                "  \"miles\": 1200,\n" +
                                "  \"interestRate\": 6.75,\n" +
                                "  \"location\": \"Seattle, WA\",\n" +
                                "  \"description\": \"Nice and clean car excellent milaze : \",\n" +
                                "  \"seller\": \"Amazing Auto\",\n" +
                                "  \"sellerPhone\": \"111-123-1234\"\n" +
                               "}")).andExpect(MockMvcResultMatchers.status().isCreated());


    }
    @Test
    public void testGetAllVehicles() throws Exception {
        List<VehicleDetail> output = Arrays.asList(
                new VehicleDetail(1, "2022", "Toyota", "Camry",
                        "LS", "", 25000.00, 50000, 3.50, "New York",
                        "This is a well-maintained vehicle with low mileage.",
                        "John Doe", "123-456-7890"),

                new VehicleDetail(1, "2021", "Honda", "Camry",
                        "LS1", "", 255000.00, 50000, 3.50, "India",
                        "This is a well-maintained vehicle with low mileage.",
                        "Narendra Kumar", "123-456-78910")

        );
        Mockito.when(vehicleDetailService.fetchAllVehicleDetails()).thenReturn(output);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vehicle-details")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].brandName").value("Honda"));
    }


}















