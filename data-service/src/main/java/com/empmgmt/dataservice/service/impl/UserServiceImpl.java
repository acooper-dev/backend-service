package com.empmgmt.dataservice.service.impl;

import com.empmgmt.dataservice.dto.TaskDto;
import com.empmgmt.dataservice.entity.Roles;
import com.empmgmt.dataservice.entity.Skill;
import com.empmgmt.dataservice.entity.Task;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.RolesRepository;
import com.empmgmt.dataservice.repository.SkillRepository;
import com.empmgmt.dataservice.repository.TaskRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import com.empmgmt.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    SkillRepository skillRepository;

    LocalDateTime now = LocalDateTime.now();

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public void createUser(String roleName, String userName, String fullName, String password){
        Roles roles  = new Roles(0,roleName, now, null);

        User user = new User(0,fullName,userName,password,now);

        roles.setUser(new HashSet<>(Collections.singletonList(user)));

        rolesRepository.save(roles);
    }

    public void addTask(String userName, List<TaskDto> tasks){
        Optional<User> user = userRepository.findByUserName(userName);

        if(user.isPresent()){
            List<Task> taskList = new ArrayList<>();

            for(TaskDto taskDto : tasks){
                Task task = new Task();
                task.setUser(user.get());
                task.setDescription(taskDto.getDescription());
                task.setStatus(taskDto.getStatus());
                task.setCreatedAt(now);
                taskList.add(task);
            }

            taskRepository.saveAll(taskList);
        }
    }

    public void addSkills(String userName, List<String> skills){
        Optional<User> user = userRepository.findByUserName(userName);

        if(user.isPresent()){
            List<Skill> skillList = new ArrayList<>();
            for(String skill : skills){
                Skill newSkill = new Skill(0,skill,now, user.get());
                skillList.add(newSkill);
            }
            skillRepository.saveAll(skillList);
        }
    }
}
