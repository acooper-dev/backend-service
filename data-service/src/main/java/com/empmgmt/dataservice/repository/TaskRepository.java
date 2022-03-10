package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tasks", itemResourceRel = "task", path = "tasks")
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value ="select * from tasks t where t.user_id = :userId", nativeQuery = true)
    List<Task> findByUserId(long userId);
}
