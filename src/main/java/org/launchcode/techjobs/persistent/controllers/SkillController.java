package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {


        private final SkillRepository skillRepository;

        @GetMapping("/skills")
        public String listSkills(Model model) {
            Iterable<Skill> skillsIterable = skillRepository.findAll();
            List<Skill> skills = new ArrayList<>();
            skillsIterable.forEach(skills::add);
            model.addAttribute("skills", skills);
            return "skills/index";
        }


        @Autowired
        public SkillController(SkillRepository skillRepository) {
            this.skillRepository = skillRepository;
        }

        @GetMapping("add")
        public String displayAddSkillForm(Model model) {
            model.addAttribute(new Skill());
            return "skills/add";
        }

        @PostMapping("add")
        public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                             Errors errors, Model model) {

            if (errors.hasErrors()) {
                return "skills/add";
            }


            return "redirect:";
        }

        @GetMapping("view/{skillId}")
        public String displayViewSkill(Model model, @PathVariable int skillId) {
            Optional<Skill> optSkill = skillRepository.findById(skillId);

            if (optSkill.isPresent()) {
                Skill skill = optSkill.get();
                model.addAttribute("skill", skill);
                return "skills/view";
            } else {
                return "redirect:";
            }
        }


}


