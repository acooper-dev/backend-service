package com.empmgmt.dataservice.utility;

import com.empmgmt.dataservice.dto.TaskDto;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.service.SkillService;
import com.empmgmt.dataservice.service.TaskService;
import com.empmgmt.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//select * from users;
//select * from roles;
//select * from user_roles;
//select * from tasks;
//select * from skills;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Autowired
    SkillService skillService;

    @Override
    public void run(String... args) {

        userService.createUser("admin","admin-user","admin user","password");

        Optional<User> user = userService.createUser("employee","acooper","Adam Cooper","password");

        skillService.addSkills(user.map(User::getUserId).orElse(0L), Arrays.asList("Java","SpringBoot","MicroServices"));

        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(0,"Learn Java8 Streams","50"));
        taskDtoList.add(new TaskDto(0,"Learn SpringBoot auto-configuration","80"));
        taskDtoList.add(new TaskDto(0,"Learn Spring Security","75"));

        taskService.addTask(user.map(User::getUserId).orElse(0L),taskDtoList);
    }
}
