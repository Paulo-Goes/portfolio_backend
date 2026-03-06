package com.paulo.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.portfolio.model.Skill;
import com.paulo.portfolio.model.SkillCategory;
import com.paulo.portfolio.repository.SkillCategoryRepository;
import com.paulo.portfolio.repository.SkillRepository;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    //CREATE
    
    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {        
        return skillRepository.save(skill);
    }
    
    
    @PostMapping("/categories")
    public SkillCategory createSkill(@RequestBody SkillCategory category) {
        return skillCategoryRepository.save(category);
    }    

    //READ

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @GetMapping("/categories")
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }

    //UPDATE

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill updated) {
        updated.setId(id);
        return skillRepository.save(updated);
    }    

    @PutMapping("/categories/{id}")
    public SkillCategory updateCategory(@PathVariable Long id, @RequestBody SkillCategory updated) {
         updated.setId(id);
         return skillCategoryRepository.save(updated);
    }

    //DELETE
    
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        skillCategoryRepository.deleteById(id);
    }
}
