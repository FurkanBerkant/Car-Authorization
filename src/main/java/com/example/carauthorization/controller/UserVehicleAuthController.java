package com.example.carauthorization.controller;

import com.example.carauthorization.model.UserVehicleAuthorization;
import com.example.carauthorization.service.abstracts.UserVehicleAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/uservehicleauth")
@AllArgsConstructor
public class UserVehicleAuthController {
    private final UserVehicleAuthService userVehicleAuthService;

    @GetMapping
    public List<UserVehicleAuthorization> getAllUserVehicleAuthorizations() {
        return userVehicleAuthService.getAllUserVehicleAuth();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVehicleAuthorization> getUserVehicleAuthorizationById(@PathVariable Long id) {
        UserVehicleAuthorization authorization = userVehicleAuthService.getUserVehicleAuthById(id).orElse(null);
        return ResponseEntity.ok(authorization);
    }

    @PostMapping
    public ResponseEntity<UserVehicleAuthorization> createUserVehicleAuthorization(@RequestBody UserVehicleAuthorization authorization) {
        UserVehicleAuthorization createdAuthorization = userVehicleAuthService.createUserVehicleAuth(authorization);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthorization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVehicleAuthorization> updateUserVehicleAuthorization(@PathVariable Long id, @RequestBody UserVehicleAuthorization authorization) {
        UserVehicleAuthorization updatedAuthorization = userVehicleAuthService.updateUserVehicleAuth(id, authorization);
        return ResponseEntity.ok(updatedAuthorization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserVehicleAuthorization(@PathVariable Long id) {
        userVehicleAuthService.deleteUserVehicleAuth(id);
        return ResponseEntity.noContent().build();
    }}
