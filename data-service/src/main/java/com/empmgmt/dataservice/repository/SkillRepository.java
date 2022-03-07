package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Skill;
import com.empmgmt.dataservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByUser(User user);
}
