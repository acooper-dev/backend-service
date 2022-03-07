package com.empmgmt.dataservice.service;

import com.empmgmt.dataservice.dto.SkillDto;

import java.util.List;

public interface SkillService {
    List<SkillDto> getSkillsByUserId(long userid);
    void addSkills(long userid, List<String> skills);
    void deleteSkill(long taskId);
}
