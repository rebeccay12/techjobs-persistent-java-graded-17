package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;

//    private String name;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
//    private String skills;

    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )

    //list or arraylist?
    private List<Skill> skills;


    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, List<Skill> skills) {
        super();
        this.employer = anEmployer;
        this.skills = skills;
    }

    // Getters and setters.
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {

         return employer;
    }

    public void setEmployer(Employer employer) {

        this.employer = employer;
    }

    public List<Skill> getSkills() {

        return skills;
    }



//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
    public void setSkills(List<Skill> skills) {

        this.skills = skills;
    }

}
