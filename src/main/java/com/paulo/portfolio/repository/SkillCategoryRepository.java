package com.paulo.portfolio.repository;

import com.paulo.portfolio.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
}