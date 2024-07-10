package com.cliniclab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
    private int id;
    private String name;
    private Date dateOfBirth;
    private List<Sample> samples;

    // Constructor
    public Patient(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.samples = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    // Método para añadir una muestra
    public void addSample(Sample sample) {
        this.samples.add(sample);
    }
}