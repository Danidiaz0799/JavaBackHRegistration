package com.java.hregistration.repositories;

import com.java.hregistration.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<PatientModel, Long>{
    
}
