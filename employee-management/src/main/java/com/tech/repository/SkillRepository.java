package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
