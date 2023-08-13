package com.example.carauthorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    @NotBlank(message = "Vehicle id cannot be blank")
    private Long vehicle_id;

    @Column(name = "plate_number", unique = true)
    @NotBlank(message = "Plate number cannot be blank")
    private String plateNumber;

    @Column(name = "chassis_number", unique = true)
    @NotBlank(message = "Chassis number cannot be blank")
    private String chassisNumber;

    @Column(name = "label")
    private String label;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private  String model;

    @Column(name = "model_year")
    private int modelYear;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
