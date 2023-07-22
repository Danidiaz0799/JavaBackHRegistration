package com.java.hregistration.services;

import com.java.hregistration.models.DoctorModel;
import com.java.hregistration.repositories.IDoctorRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
 
    @Autowired
    IDoctorRepository doctorRepository;
    
    public ArrayList<DoctorModel> getDoctors(){
        return (ArrayList<DoctorModel>) doctorRepository.findAll();
    }
    
    public DoctorModel saveDoctor(DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }
    
    public Optional<DoctorModel> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }
    
    public DoctorModel updateDoctor(DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }
    
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    
}
