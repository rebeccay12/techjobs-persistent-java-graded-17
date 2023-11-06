package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    //should this be changed to @NotNull like AbstractEntity or should I keep it @NotBlank?
    @NotBlank(message = "Location cannot be empty")
    @Size(min = 1, max = 100, message = "Location must be between 1 and 100 characters")
    private String location;

    public Employer() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


