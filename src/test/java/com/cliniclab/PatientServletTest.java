package com.cliniclab;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.cliniclab.model.Patient;
import com.cliniclab.servlet.PatientServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

class PatientServletTest {

    private PatientServlet servlet;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        servlet = new PatientServlet();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testAddPatient() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("John Doe");
        patient.setDateOfBirth(new Date());

        request.setContent(objectMapper.writeValueAsBytes(patient));
        servlet.doPost(request, response);

        assertEquals(201, response.getStatus());
    }

    @Test
    void testGetPatient() throws IOException {
        // First, add a patient
        testAddPatient();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setPathInfo("/1");
        servlet.doGet(request, response);

        Patient retrievedPatient = objectMapper.readValue(response.getContentAsString(), Patient.class);
        assertEquals(1, retrievedPatient.getId());
        assertEquals("John Doe", retrievedPatient.getName());
    }

    @Test
    void testGetAllPatients() throws IOException {
        // First, add a patient
        testAddPatient();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        servlet.doGet(request, response);

        List<Patient> patients = objectMapper.readValue(response.getContentAsString(), List.class);
        assertFalse(patients.isEmpty());
    }
}
