package com.example.carauthorization.controller;

import com.example.carauthorization.model.User;
import com.example.carauthorization.model.dtos.UserAuth;
import com.example.carauthorization.model.dtos.UserResponse;
import com.example.carauthorization.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User>getOneUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateOneUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
