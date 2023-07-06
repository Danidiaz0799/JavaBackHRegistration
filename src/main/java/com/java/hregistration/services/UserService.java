package com.java.hregistration.services;

import com.java.hregistration.models.UserModel;
import com.java.hregistration.repositories.IUserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 
    @Autowired
    IUserRepository userRepository;
    
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public UserModel updateUser(UserModel user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
