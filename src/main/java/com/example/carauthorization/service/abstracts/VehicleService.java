package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.Vehicle;
import com.example.carauthorization.model.dtos.VehicleDto;

import java.util.List;

public interface VehicleService {
    public List<VehicleDto> getAllVehicles();
    public Vehicle getVehicleById(Long vehicleId);
    public Vehicle createVehicle(Vehicle vehicles);
    public Vehicle updateVehicle(Long vehicleId, Vehicle updatedVehicle);
    public void deleteVehicle(Long vehicleId);
}
