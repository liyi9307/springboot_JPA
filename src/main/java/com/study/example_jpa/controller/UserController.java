package com.study.example_jpa.controller;

import com.study.example_jpa.entity.User;
import com.study.example_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "helloword";
    }
    @GetMapping("/findById")
    public User findById(@PathVariable("id")int id){
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            return userOptional.get();
        }
        return null;
    }

    @RequestMapping("/save")
    public String saveUser(String name, int age, String password){
        User user = new User(name, age, password);
        userService.saveUser(user);
        return "successful";
    }


    @RequestMapping("/findByName")
    public List<User> findByName(String name){
        return userService.fingByName(name);
    }
}
