package com.spring.jwt.repositories;

import com.spring.jwt.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByName(String name);
}
