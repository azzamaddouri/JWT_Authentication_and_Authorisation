package com.spring.jwt.user;

import com.spring.jwt.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <AppUser,Integer>{
    Optional<AppUser> findByEmail(String email);
}
