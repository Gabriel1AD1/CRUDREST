package com.crud.springrestwebcrud.service;

import com.crud.springrestwebcrud.model.User;
import com.crud.springrestwebcrud.respository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<User> getUser(){
        return (ArrayList<User>)userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getById(long id){
        return userRepository.findById(id);
    }

    public User updateById(User request, Long id){
      User user = userRepository.findById(id).get();
      user.setFirtsName(request.getFirtsName());
      user.setLastName(request.getLastName());
      user.setEmail(request.getEmail());

      return user;
    }

    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
