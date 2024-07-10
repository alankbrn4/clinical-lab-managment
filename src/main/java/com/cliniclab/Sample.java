package com.cliniclab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sample {
    private int id;
    private Date collectionDate;
    private String type;
    private List<TestResult> results;

    // Constructor
    public Sample(int id, Date collectionDate, String type) {
        this.id = id;
        this.collectionDate = collectionDate;
        this.type = type;
        this.results = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public String getType() {
        return type;
    }

    public List<TestResult> getResults() {
        return results;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }

    // Método para añadir un resultado
    public void addResult(TestResult result) {
        this.results.add(result);
    }
}