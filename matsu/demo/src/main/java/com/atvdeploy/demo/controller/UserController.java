package com.atvdeploy.demo.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atvdeploy.demo.exception.UserNotFoundException;
import com.atvdeploy.demo.model.User;
import com.atvdeploy.demo.service.UserService;
 
@RestController
@RequestMapping("api/User")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/add")
    public ResponseEntity<User> insertUser(@RequestBody User u) {
        User newUser = userService.insertUser(u);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteByIdUserHandler(@PathVariable("id") Long id) {
        try {
            userService.deleteByIdUser(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<User> findByIdUserHandler(@PathVariable("id") Long id) {
        try {
            User user = userService.getByIdUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUserHandler() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<String> updateByIdUserHandler(@PathVariable("id") Long id, @RequestParam String newname) {
        try {
            userService.updateByIdUser(newname, id);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
 