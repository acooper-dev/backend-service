package com.empmgmt.dataservice.utility;

import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.service.TaskService;
import com.empmgmt.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//select * from users;
//select * from roles;
//select * from user_roles;
//select * from tasks;
//select * from skills;

@Component
public class  InitData implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Override
    public void run(String... args) {

        userService.createUser("admin","admin-user","admin user","password");

        Optional<User> user = userService.createUser("employee","acooper","Adam Cooper","password");
        Optional<User> user2 = userService.createUser("employee","jbrady","John Brady","password");

//      List<TaskDto> taskDtoList = new ArrayList<>();
//      taskDtoList.add(new TaskDto(0,"Learn Java8 Streams","50"));
//      taskDtoList.add(new TaskDto(0,"Learn SpringBoot auto-configuration","80"));
//      taskDtoList.add(new TaskDto(0,"Learn Spring Security","75"));
//
//      List<TaskDto> taskDtoList2 = new ArrayList<>();
//      taskDtoList2.add(new TaskDto(0,"Learn Postman","60"));
//      taskDtoList2.add(new TaskDto(0,"Learn Docker","85"));
//
//      taskService.addTask(user.map(User::getUserId).orElse(0L),taskDtoList);
//      8585taskService.addTask(user2.map(User::getUserId).orElse(0L),taskDtoList2);
    }
}
