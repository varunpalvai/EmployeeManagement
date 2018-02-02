package com.tech.service;

import java.util.List;

import com.tech.domain.Skill;

public interface SkillService {
	
	public Skill save(Skill skill);
	public void delete(Long skillId);
	public List<Skill> getSkills();

}
