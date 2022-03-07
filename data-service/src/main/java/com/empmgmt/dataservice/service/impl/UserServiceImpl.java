package com.empmgmt.dataservice.service.impl;

import com.empmgmt.dataservice.entity.Roles;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.RolesRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import com.empmgmt.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    LocalDateTime now = LocalDateTime.now();

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public Optional<User> createUser(String roleName, String userName, String fullName, String password){
        Roles roles  = new Roles(0,roleName, now, null);

        User user = new User(0,fullName,userName,password,now);

        roles.setUser(new HashSet<>(Collections.singletonList(user)));

        rolesRepository.save(roles);

        return findByUsername(userName);
    }
}
