package com.telusko.ecom_proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telusko.ecom_proj.model.User;

@Repository
public interface UserRepo extends  JpaRepository<User, Integer> {
    
}
