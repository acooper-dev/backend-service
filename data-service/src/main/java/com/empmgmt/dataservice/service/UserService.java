package com.empmgmt.dataservice.service;

import com.empmgmt.dataservice.dto.UserDto;
import com.empmgmt.dataservice.entity.Role;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.RoleRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    RoleRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    LocalDateTime now = LocalDateTime.now();

    public Optional<User> createUser(String roleName, String userName, String fullName, String password){

        Role role = rolesRepository.findByRoleName(roleName).orElseGet(() -> {
            Role _role = new Role(0, roleName, now);
            return rolesRepository.save(_role);
        } );

        User user = userRepository.save(new User(0, fullName, userName, password, now));

        role.addUser(user);
        rolesRepository.save(role);
        return userRepository.findByUserName(userName);
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
