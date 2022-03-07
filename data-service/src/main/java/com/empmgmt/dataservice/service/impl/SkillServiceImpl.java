package com.empmgmt.dataservice.service.impl;

import com.empmgmt.dataservice.dto.SkillDto;
import com.empmgmt.dataservice.entity.Skill;
import com.empmgmt.dataservice.entity.User;
import com.empmgmt.dataservice.repository.SkillRepository;
import com.empmgmt.dataservice.repository.UserRepository;
import com.empmgmt.dataservice.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SkillServiceImpl implements SkillService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    SkillRepository skillRepository;

    LocalDateTime now = LocalDateTime.now();

    public List<SkillDto> getSkillsByUserId(long userid) {
        User user = userRepository.getById(userid);
        List<Skill> skillList = skillRepository.findByUser(user);
        List<SkillDto> skillDtoList = new ArrayList<>();
        skillList.forEach(skill -> skillDtoList.add(skillToSkillDto(skill) ));
        return skillDtoList;
    }

    public void addSkills(long userid, List<String> skills){
        Optional<User> user = userRepository.findById(userid);

        if(user.isPresent()){
            List<Skill> skillList = new ArrayList<>();
            skills.forEach(
                    skillDesc -> {
                        Skill newSkill = new Skill();
                        newSkill.setDescription(skillDesc);
                        newSkill.setUser(user.get());
                        newSkill.setCreatedAt(now);
                        skillList.add(newSkill);
                    });
            skillRepository.saveAll(skillList);
        }
    }

    public void deleteSkill(long skillId) {
        Skill skill = skillRepository.getById(skillId);
        skillRepository.delete(skill);
    }

    public SkillDto skillToSkillDto(Skill skill){
        SkillDto skillDto = new SkillDto();
        skillDto.setSkillId(skill.getSkillId());
        skillDto.setDescription(skill.getDescription());
        return skillDto;
    }

    public Skill skillDtoToSkill(SkillDto skillDto){
        Skill skill = new Skill();
        skill.setSkillId(skillDto.getSkillId());
        skill.setDescription(skillDto.getDescription());
        return skill;
    }
}
