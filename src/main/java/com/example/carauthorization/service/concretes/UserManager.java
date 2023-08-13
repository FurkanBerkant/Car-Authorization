package com.example.carauthorization.service.concretes;

import com.example.carauthorization.config.dtoConverter.DtoConverterService;
import com.example.carauthorization.model.User;
import com.example.carauthorization.model.dtos.UserResponse;
import com.example.carauthorization.repository.UserRepository;
import com.example.carauthorization.service.abstracts.UserService;
import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private DtoConverterService dtoConverterService;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return dtoConverterService.dtoConverter(users, UserResponse.class);
    }
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User updateUser(Long userId, User updatedUser) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(updatedUser.getUserName());
            foundUser.setSurName(updatedUser.getSurName());
            foundUser.setCompany(updatedUser.getCompany());
            foundUser.setRole(updatedUser.getRole());
            return userRepository.save(foundUser);
        } else {
            return null;
        }
    }
    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getOneUserByUserName(String user_name) {
        return userRepository.findByUserName(user_name);
    }
}