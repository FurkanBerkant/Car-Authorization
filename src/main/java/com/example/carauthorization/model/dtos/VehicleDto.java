package com.example.carauthorization.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VehicleDto {
    @NotBlank(message = "Plate number cannot be blank")
    private String plateNumber;
    @NotBlank(message = "Chassis number cannot be blank")
    private String chassisNumber;
    private String label;
    private String brand;
    private String model;
    private int modelYear;

}
