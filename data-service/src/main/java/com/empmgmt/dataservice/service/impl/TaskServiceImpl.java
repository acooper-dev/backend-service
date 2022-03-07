package com.empmgmt.dataservice.service.impl;

import com.empmgmt.dataservice.dto.TaskDto;
import com.empmgmt.dataservice.entity.Task;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.TaskRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import com.empmgmt.dataservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    LocalDateTime now = LocalDateTime.now();

    public List<TaskDto> getTasksByUserId(long userid) {

        User user = userRepository.getById(userid);
        List<Task> taskList = taskRepository.findByUser(user);
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskList.forEach(task -> taskDtoList.add(taskToTaskDto(task) ));
        return taskDtoList;
    }

    public void addTask(long userid, List<TaskDto> tasks){
        Optional<User> user = userRepository.findById(userid);

        if(user.isPresent()){
            List<Task> taskList = new ArrayList<>();
            tasks.stream().map(this::taskDtoToTask).forEach(task -> {
                task.setCreatedAt(now);
                task.setUser(user.get());
                taskList.add(task);
            });
            taskRepository.saveAll(taskList);
        }
    }

    public void deleteTask(long taskId) {
        Task task = taskRepository.getById(taskId);
        taskRepository.delete(task);
    }

    public TaskDto taskToTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

    public Task taskDtoToTask(TaskDto taskDto){
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
