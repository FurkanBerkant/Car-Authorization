package com.example.carauthorization.controller;

import com.example.carauthorization.model.UserGroupAuthorization;
import com.example.carauthorization.model.UserVehicleAuthorization;
import com.example.carauthorization.service.abstracts.UserGroupAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usergroupauth")
@AllArgsConstructor
public class UserGroupAuthController {

    private final UserGroupAuthService userGroupAuthService;
    @GetMapping
    public List<UserGroupAuthorization> getAllUserGroupAuthorizations() {
        return userGroupAuthService.getAllUserGroupAuth();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroupAuthorization> getUserGroupAuthorizationById(@PathVariable Long id) {
        UserGroupAuthorization authorization = userGroupAuthService.getUserGroupAuthById(id).orElse(null);
        return ResponseEntity.ok(authorization);
    }

    @PostMapping
    public ResponseEntity<UserGroupAuthorization> createUserGroupAuthorization(@RequestBody UserGroupAuthorization authorization) {
        UserGroupAuthorization createdAuthorization = userGroupAuthService.createUserGroupAuth(authorization);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthorization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGroupAuthorization> updateUserGroupAuthorization(@PathVariable Long id, @RequestBody UserGroupAuthorization authorization) {
        UserGroupAuthorization updatedAuthorization = userGroupAuthService.updateUserGroupAuth(id, authorization);
        return ResponseEntity.ok(updatedAuthorization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGroupAuthorization(@PathVariable Long id) {
        userGroupAuthService.deleteUserGroupAuth(id);
        return ResponseEntity.noContent().build();
    }}