package com.cliniclab;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPatientDatabase {
    private Map<Integer, Patient> patientMap;
    private ReentrantLock lock;

    // Constructor
    public ConcurrentPatientDatabase() {
        this.patientMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    // Método para añadir un paciente de forma thread-safe
    public void addPatient(Patient patient) {
        lock.lock();
        try {
            patientMap.put(patient.getId(), patient);
        } finally {
            lock.unlock();
        }
    }

    // Método para obtener un paciente de forma thread-safe
    public Patient getPatient(int id) {
        lock.lock();
        try {
            return patientMap.get(id);
        } finally {
            lock.unlock();
        }
    }

    // Método sincronizado para actualizar un paciente
    public synchronized void updatePatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }
}