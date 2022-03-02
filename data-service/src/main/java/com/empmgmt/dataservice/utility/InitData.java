package com.empmgmt.dataservice.utility;

import com.empmgmt.dataservice.dto.TaskDto;
import com.empmgmt.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//select * from users;
//select * from roles;
//select * from user_roles;
//select * from tasks;
//select * from skills;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) {

        userService.createUser("admin","admin-user","admin user","password");
        userService.createUser("employee","acooper","Adam Cooper","password");

        userService.addSkills("acooper", Arrays.asList("Java","SpringBoot","MicroServices"));

        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(0,"Learn Java8 Streams","0",null));
        taskDtoList.add(new TaskDto(0,"Learn SpringBoot auto-configuration","0",null));
        taskDtoList.add(new TaskDto(0,"Learn Spring Security","0",null));

        userService.addTask("acooper",taskDtoList);
    }
}
