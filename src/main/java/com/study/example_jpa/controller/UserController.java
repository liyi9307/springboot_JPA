package com.study.example_jpa.controller;

import com.study.example_jpa.entity.User;
import com.study.example_jpa.entity.UserName;
import com.study.example_jpa.service.UserNameService;
import com.study.example_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserNameService userNameService;

    @RequestMapping("/hello")
    public String hello(){
        return "helloword";
    }
    @GetMapping("/findById")
    public User findById(@PathParam(value = "id") int id){
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

    @RequestMapping("/findAll")
    public List<User> findByName(){
        return userService.findAll();
    }

    @RequestMapping("/findByName")
    public List<User> findByName(String name){
        return userService.fingByName(name);
    }

    @RequestMapping("/sessionCache")
    public User sessionCache(){
        return userService.sessionCache();
    }
    @RequestMapping("/secondCache")
    public List<UserName> secondCache(@PathParam(value = "name") String name){
        return userNameService.secondCache(name);
    }

}
