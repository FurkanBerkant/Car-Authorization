package com.example.carauthorization.repository;

import com.example.carauthorization.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
