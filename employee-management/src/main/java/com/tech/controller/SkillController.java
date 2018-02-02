package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.Skill;
import com.tech.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public List<Skill> getSkills() {
		List<Skill> skillList = skillService.getSkills();
		return skillList;
	}
	
	@RequestMapping(value = "/skill", method = RequestMethod.POST)
	public Skill save(@RequestBody Skill skill) {
		Skill newSkill = skillService.save(skill);
		return newSkill;
	}
	
	@RequestMapping(value = "/{skillId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name = "skillId") Long skillId) {
		skillService.delete(skillId);
		return "skill deleted successfully";
	}

}
