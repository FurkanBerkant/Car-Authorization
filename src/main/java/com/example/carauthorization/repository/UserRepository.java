package com.example.carauthorization.repository;

import com.example.carauthorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User getOneUserById(Long id);

    User findByUserName(String username);
}
