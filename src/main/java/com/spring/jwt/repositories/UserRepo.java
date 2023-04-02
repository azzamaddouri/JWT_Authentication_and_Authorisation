package com.spring.jwt.repositories;

import com.spring.jwt.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <AppUser,Long>{
    AppUser findByUsername(String username);
}
