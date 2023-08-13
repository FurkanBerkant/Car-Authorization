package com.example.carauthorization.repository;

import com.example.carauthorization.model.UserGroupAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupAuthRepo extends JpaRepository<UserGroupAuthorization, Long> {
}
