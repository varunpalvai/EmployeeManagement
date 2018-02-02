package com.tech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.SkillRepository;
import com.tech.domain.Skill;
import com.tech.service.SkillService;

@Service (value = "skillService")
public class SillServiceImpl implements SkillService {
	
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Skill save(Skill skill) {
		Skill newSkill = skillRepository.save(skill);
		return newSkill;
	}

	@Override
	public void delete(Long skillId) {
		skillRepository.delete(skillId);
	}

	@Override
	public List<Skill> getSkills() {
		List<Skill> skills = skillRepository.findAll();
		return skills;
	}

}
