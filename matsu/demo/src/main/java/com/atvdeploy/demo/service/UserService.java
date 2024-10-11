package com.atvdeploy.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atvdeploy.demo.exception.UserNotFoundException;
import com.atvdeploy.demo.model.User;
import com.atvdeploy.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired(required=false)
    private UserRepository userRepository;

    public User insertUser(User u){
        return userRepository.save(u);
    }
    public User getByIdUser(Long id) throws UserNotFoundException{
        Optional<User>opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            return opUser.get();
        }
        throw new UserNotFoundException("User not found");
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User updateByIdUser(String newname, Long id) throws UserNotFoundException{
        Optional<User>opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            User u = opUser.get();
            u.setName(newname);

            return userRepository.save(u);
        }
        throw new UserNotFoundException("User not found");
    }
    public void deleteByIdUser(Long id) throws UserNotFoundException{
        Optional<User> opUser = userRepository.findById(id);
        if(opUser.isPresent()){
            userRepository.deleteById(id);
        }
        throw new UserNotFoundException("User not found");
    }
}
