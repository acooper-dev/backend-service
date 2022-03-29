package com.emp.servicedata.repository;

import com.emp.servicedata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "users", itemResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}
