package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;

@Entity
public class Skill extends AbstractEntity {
    @NotBlank(message = "Description cannot be empty")
    @Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private ArrayList<Job> jobs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }
}
