package com.empmgmt.dataservice.service;

import com.empmgmt.dataservice.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasksByUserId(long userid);
    void addTask(long userid, List<TaskDto> tasks);
    void deleteTask(long taskId);
}
