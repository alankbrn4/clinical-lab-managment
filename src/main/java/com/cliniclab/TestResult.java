package com.cliniclab;

import java.util.Date;

public class TestResult {
    private String testName;
    private double value;
    private String unit;
    private Date resultDate;

    // Constructor
    public TestResult(String testName, double value, String unit, Date resultDate) {
        this.testName = testName;
        this.value = value;
        this.unit = unit;
        this.resultDate = resultDate;
    }

    // Getters
    public String getTestName() {
        return testName;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public Date getResultDate() {
        return resultDate;
    }

    // Setters
    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }
}