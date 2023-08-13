package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.User;
import com.example.carauthorization.model.dtos.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserResponse> getAllUsers();
    public User getUserById(Long userId);
    public User createUser(User user);
    public User updateUser(Long userId, User updatedUser);
    public void deleteById(Long userId);
    User getOneUserByUserName(String user_name);

}
