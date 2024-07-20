package com.cliniclab.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliniclab.dao.PatientDAO;
import com.cliniclab.model.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;


//@WebServlet("/patients/*")
public class PatientServlet extends HttpServlet {
    private PatientDAO patientDAO = new PatientDAO();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            objectMapper.writeValue(resp.getOutputStream(), patientDAO.getAllPatients());
        } else {
            String[] splits = pathInfo.split("/");
            if (splits.length == 2) {
                int id = Integer.parseInt(splits[1]);
                Patient patient = patientDAO.getPatient(id);
                if (patient != null) {
                    objectMapper.writeValue(resp.getOutputStream(), patient);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Patient patient = objectMapper.readValue(req.getInputStream(), Patient.class);
        patientDAO.addPatient(patient);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}