package com.empmgmt.dataservice.repository;

import com.empmgmt.dataservice.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
