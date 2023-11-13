package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;

//    @Autowired
//    public HomeController(EmployerRepository employerRepository, SkillRepository skillRepository, JobRepository jobRepository) {
//        this.employerRepository = employerRepository;
//        this.skillRepository = skillRepository;
//        this.jobRepository = jobRepository;
//    }

    @GetMapping
    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Job> jobs = jobRepository.findAll();
        model.addAttribute("title", "MyJobs");
        model.addAttribute("jobs", jobs);

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	    //use iterable to get data from employerRepostiory
        Iterable<Employer> employers = employerRepository.findAll();
        Iterable<Skill> skills = skillRepository.findAll();

        //add data
        model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employers);
        model.addAttribute(new Job());
        model.addAttribute("skills", skills);
        return "add";
    }

//    @PostMapping("add")
//    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
//                                       Errors errors, Model model, @RequestParam int employerId) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Job");
//            return "add";
//        }
//
//        Optional<Employer> optionalEmployer = employerRepository.findById(employerId);
//
//        if (optionalEmployer.isPresent()) {
//            Employer selectedEmployer = optionalEmployer.get();
//            newJob.setEmployer(selectedEmployer);
//
//            return "redirect:";
//        } else {
//            return "add";
//        }
//    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }
        Optional<Employer> employerOptional = employerRepository.findById(employerId);

        if (employerOptional.isPresent()) {
            Employer selectedEmployer = employerOptional.get();
            newJob.setEmployer(selectedEmployer);
        }
            List<Skill> skillObjs = (List<Skill>)
            skillRepository.findAllById(skills);
            newJob.setSkills(skillObjs);
           //save the job
            jobRepository.save(newJob);
            return "redirect:";
//        } else {
//            return "add";
        }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            model.addAttribute("job", job);
            return "view";

        } else {
            return "redirect:/";
        }
    }

}
