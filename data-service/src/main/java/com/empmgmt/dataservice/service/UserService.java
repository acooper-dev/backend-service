package com.empmgmt.dataservice.service;

import com.empmgmt.dataservice.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    Optional<User> createUser(String roleName, String userName, String fullName, String password);
}
