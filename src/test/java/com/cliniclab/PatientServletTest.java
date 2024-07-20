package com.cliniclab;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.cliniclab.model.Patient;
import com.cliniclab.servlet.PatientServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

class PatientServletTest {

    private TestPatientServlet servlet;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        servlet = new TestPatientServlet();
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

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            fail("ServletException thrown: " + e.getMessage());
        }

        assertEquals(201, response.getStatus());
    }

    @Test
    void testGetPatient() throws IOException {
        // First, add a patient
        testAddPatient();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.setPathInfo("/1");

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            fail("ServletException thrown: " + e.getMessage());
        }

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

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            fail("ServletException thrown: " + e.getMessage());
        }

        List<Patient> patients = objectMapper.readValue(response.getContentAsString(), List.class);
        assertFalse(patients.isEmpty());
    }

    // Subclass to expose protected methods
    private static class TestPatientServlet extends PatientServlet {
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doGet(req, resp);
        }

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doPost(req, resp);
        }
    }
}
