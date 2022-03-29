package com.emp.servicedata.utility;

import com.emp.servicedata.entity.User;
import com.emp.servicedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//select * from users;
//select * from roles;
//select * from user_roles;
//select * from tasks;
//select * from skills;

@Component
public class  InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) {

        User user  = new User(0, "Adam Cooper", "acooper","password", LocalDateTime.now());
        User user1  = new User(0, "Adam Cooper1", "acooper1","password", LocalDateTime.now());
        User user2  = new User(0, "Adam Cooper2", "acooper2","password", LocalDateTime.now());

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
