package com.empmgmt.dataservice.service;

import com.empmgmt.dataservice.dto.TaskDto;
import com.empmgmt.dataservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void createUser(String roleName, String userName, String fullName, String password);

    void addTask(String userName, List<TaskDto> tasks);

    void addSkills(String userName, List<String> skills);
}
