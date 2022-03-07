package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Task;
import com.empmgmt.dataservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser(User user);
}
