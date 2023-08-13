package com.example.carauthorization.service.concretes;
import com.example.carauthorization.Exception.NotFoundException;
import com.example.carauthorization.config.dtoConverter.DtoConverterService;
import com.example.carauthorization.model.User;
import com.example.carauthorization.model.Vehicle;
import com.example.carauthorization.model.dtos.UserResponse;
import com.example.carauthorization.model.dtos.VehicleDto;
import com.example.carauthorization.repository.VehicleRepository;
import com.example.carauthorization.service.abstracts.VehicleService;
import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleManager implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private DtoConverterService dtoConverterService;

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return dtoConverterService.dtoConverter(vehicles, VehicleDto.class);

    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException("Vehicle not found id:"+vehicleId));

    }

    @Override
    public Vehicle createVehicle(Vehicle vehicles) {
        return vehicleRepository.save(vehicles);
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle updatedVehicle) {
        Optional<Vehicle> vehicles = vehicleRepository.findById(vehicleId);
        if (vehicles.isPresent()) {
            Vehicle foundVehicle = vehicles.get();
            foundVehicle.setPlateNumber(updatedVehicle.getPlateNumber());
            foundVehicle.setChassisNumber(updatedVehicle.getChassisNumber());
            foundVehicle.setLabel(updatedVehicle.getLabel());
            foundVehicle.setBrand(updatedVehicle.getBrand());
            foundVehicle.setModel(updatedVehicle.getModel());
            foundVehicle.setModelYear(updatedVehicle.getModelYear());
            foundVehicle.setCompany(updatedVehicle.getCompany());
            return vehicleRepository.save(foundVehicle);
        } else {
            return null;
        }

    }
    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}