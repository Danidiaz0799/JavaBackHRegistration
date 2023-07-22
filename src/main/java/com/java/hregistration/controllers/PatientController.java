package com.java.hregistration.controllers;

import com.java.hregistration.models.PatientModel;
import com.java.hregistration.services.PatientService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients/")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping
    public ArrayList<PatientModel> getPatients(){
        return this.patientService.getPatients();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable Long id) {
        Optional<PatientModel> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        } else {
            String errorMessage = "Patient not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public PatientModel savePatient(@RequestBody PatientModel patient) {
        return this.patientService.savePatient(patient);
    }

}
