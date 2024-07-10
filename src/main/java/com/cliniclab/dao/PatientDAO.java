package com.cliniclab.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.cliniclab.model.Patient;

public class PatientDAO {
    private static final ConcurrentHashMap<Integer, Patient> patients = new ConcurrentHashMap<>();

    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    public Patient getPatient(int id) {
        return patients.get(id);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }
}