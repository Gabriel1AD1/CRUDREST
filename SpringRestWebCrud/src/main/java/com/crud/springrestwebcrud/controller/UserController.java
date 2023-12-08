package com.crud.springrestwebcrud.controller;

import ch.qos.logback.core.net.server.Client;
import com.crud.springrestwebcrud.model.User;
import com.crud.springrestwebcrud.respository.IUserRepository;
import com.crud.springrestwebcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<User> getUser(){
        return this.userService.getUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable("id")  Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public User updateUserById(@RequestBody User user,@PathVariable("id") Long id){
        return this.userService.updateById(user,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
        boolean ok = this.userService.deleteUser(id);

        if (ok){
            return "User Whit id "+id+"Delete";
        }else {
            return "Failet Delete";
        }
    }
}
