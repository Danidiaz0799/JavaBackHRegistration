package com.java.hregistration.controllers;

import com.java.hregistration.models.DoctorModel;
import com.java.hregistration.services.DoctorService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors/")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping
    public ArrayList<DoctorModel> getDoctors(){
        return this.doctorService.getDoctors();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable Long id) {
        Optional<DoctorModel> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        } else {
            String errorMessage = "Doctor not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public DoctorModel saveDoctor(@RequestBody DoctorModel doctor) {
        return this.doctorService.saveDoctor(doctor);
    }
    



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        Optional<DoctorModel> existingDoctor = doctorService.getDoctorById(id);
        if (existingDoctor.isPresent()) {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
        }
    }

}
