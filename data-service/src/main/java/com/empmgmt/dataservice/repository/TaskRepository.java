package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
