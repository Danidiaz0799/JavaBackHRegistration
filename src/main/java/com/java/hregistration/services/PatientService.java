package com.java.hregistration.services;

import com.java.hregistration.models.PatientModel;
import com.java.hregistration.repositories.IPatientRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
 
    @Autowired
    IPatientRepository patientRepository;
    
    public ArrayList<PatientModel> getPatients(){
        return (ArrayList<PatientModel>) patientRepository.findAll();
    }
    
    public PatientModel savePatient(PatientModel patient) {
        return patientRepository.save(patient);
    }
    
    public Optional<PatientModel> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    
    public PatientModel updatePatient(PatientModel patient) {
        return patientRepository.save(patient);
    }
    
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    
}
