package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "roles", itemResourceRel = "role", path = "role")
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);
}
