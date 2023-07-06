package com.java.hregistration.repositories;

import com.java.hregistration.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long>{
    
}
