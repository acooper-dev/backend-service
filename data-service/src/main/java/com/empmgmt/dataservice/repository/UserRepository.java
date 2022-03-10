package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "users", itemResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}
