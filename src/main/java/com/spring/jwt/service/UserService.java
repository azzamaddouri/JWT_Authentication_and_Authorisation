package com.spring.jwt.service;

import com.spring.jwt.models.AppRole;
import com.spring.jwt.models.AppUser;

import java.util.List;

public interface UserService {
    // Save user in database
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
