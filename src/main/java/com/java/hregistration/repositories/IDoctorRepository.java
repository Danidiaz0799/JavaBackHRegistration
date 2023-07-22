package com.java.hregistration.repositories;

import com.java.hregistration.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<DoctorModel, Long>{
    
}
