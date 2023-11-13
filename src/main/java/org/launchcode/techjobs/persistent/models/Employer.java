package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    //should this be changed to @NotBlank?
    @NotNull
    @Size(min = 1, max = 255)
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")
    //list or array list?
    private List<Job> jobs;
    public Employer(){
        jobs = new ArrayList<>();
    }

//    public Employer() {
//    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public List<Job> getJobs() {

        return jobs;
    }
}


