package com.example.carauthorization.repository;

import com.example.carauthorization.model.UserVehicleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVehicleAuthRepo extends JpaRepository<UserVehicleAuthorization, Long> {
}
