package com.empmgmt.dataservice.utility;

import com.empmgmt.dataservice.entity.Roles;
import com.empmgmt.dataservice.entity.Skill;
import com.empmgmt.dataservice.entity.Task;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.RolesRepository;
import com.empmgmt.dataservice.repository.SkillRepository;
import com.empmgmt.dataservice.repository.TaskRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;


//select * from users;
//select * from roles;
//select * from user_roles;
//select * from tasks;
//select * from skills;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    SkillRepository skillRepository;

    LocalDateTime now = LocalDateTime.now();

    @Override
    public void run(String... args) {

        CreateUser("admin","admin-user","admin user","password");
        CreateUser("employee","acooper","Adam Cooper","password");

        AddSkills("acooper",Arrays.asList("Java","SpringBoot","MicroServices"));

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(0,"Learn Java8 Streams","0",now,null));
        taskList.add(new Task(0,"Learn SpringBoot auto-configuration","0",now,null));
        taskList.add(new Task(0,"Learn Spring Security","0",now,null));

        AddTask("acooper",taskList);
    }

    public void CreateUser(String roleName,String userName, String fullName, String password){
        Roles roles  = new Roles(0,roleName, now,null);

        User user = new User(0,fullName,userName,password,now);

        roles.setUser(new HashSet<>(Collections.singletonList(user)));

        rolesRepository.save(roles);
    }

    public void AddTask(String userName, List<Task> tasks){
        User user = userRepository.findByUserName(userName);

        if(user != null){
            for(Task task : tasks){
                task.setUser(user);
            }
            taskRepository.saveAll(tasks);
        }
    }

    public void AddSkills(String userName, List<String> skills){
        User user = userRepository.findByUserName(userName);

        if(user != null){
            List<Skill> skillList = new ArrayList<>();
            for(String skill : skills){
                Skill newSkill = new Skill(0,skill,now, user);
                skillList.add(newSkill);
            }
            skillRepository.saveAll(skillList);
        }
    }
}
