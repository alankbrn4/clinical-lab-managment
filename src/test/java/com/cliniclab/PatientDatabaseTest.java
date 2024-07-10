package com.cliniclab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PatientDatabaseTest {

    @Test
    void testAddAndGetPatient() {
        PatientDatabase db = new PatientDatabase();
        Patient patient = new Patient(1, "Test Patient", new Date());
        
        db.addPatient(patient);
        Patient retrievedPatient = db.getPatient(1);
        
        assertNotNull(retrievedPatient);
        assertEquals(patient.getId(), retrievedPatient.getId());
        assertEquals(patient.getName(), retrievedPatient.getName());
    }

    @Test
    void testGetNonExistentPatient() {
        PatientDatabase db = new PatientDatabase();
        Patient retrievedPatient = db.getPatient(999);
        
        assertNull(retrievedPatient);
    }
}
