package com.telusko.ecom_proj.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.telusko.ecom_proj.repo.UserRepo;

import lombok.RequiredArgsConstructor;

import com.telusko.ecom_proj.model.User;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
    
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    
    public User getUserbyId(int id) throws NoSuchElementException  {
        return userRepo.findById(id).get();
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
