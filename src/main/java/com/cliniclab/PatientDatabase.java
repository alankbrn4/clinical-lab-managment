package com.cliniclab;

import java.util.HashMap;
import java.util.Map;

public class PatientDatabase {
    private Map<Integer, Patient> patientMap;

    // Constructor
    public PatientDatabase() {
        this.patientMap = new HashMap<>();
    }

    // Método para añadir un paciente
    public void addPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }

    // Método para obtener un paciente
    public Patient getPatient(int id) {
        return patientMap.get(id);
    }

    // Getter para el mapa de pacientes (si es necesario)
    public Map<Integer, Patient> getPatientMap() {
        return patientMap;
    }
}