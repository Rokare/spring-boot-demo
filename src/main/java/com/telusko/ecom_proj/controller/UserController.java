package com.telusko.ecom_proj.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telusko.ecom_proj.model.User;
import com.telusko.ecom_proj.service.UserService;


import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserbyId(@PathVariable int id) {
        try {
            return new ResponseEntity<>(userService.getUserbyId(id), HttpStatus.OK);
        } catch (NoSuchElementException  ex) {
            return new ResponseEntity<>("User not Found", HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserbyId(@PathVariable int id) {
        try {
            userService.getUserbyId(id);
            userService.deleteUser(id);
            return new ResponseEntity<>("User Deleted !", HttpStatus.ACCEPTED);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>("User not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            User user1 = userService.getUserbyId(user.getId());
            if (user1 != null ) {
                user1 = userService.updateUser(user);
                return new ResponseEntity<>("User updated !", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update user", HttpStatus.BAD_REQUEST);
            }
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(MessageFormat.format("No User Found with this id: {0}", user.getId()), HttpStatus.NOT_FOUND);
        }

     
    }
}
