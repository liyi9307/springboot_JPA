package com.study.example_jpa.service;

import com.study.example_jpa.dao.UserDao;
import com.study.example_jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(User user){
        userDao.save(user);
    }

    public Optional<User> findById(int id){
        return userDao.findById(id);
    }

    public List<User> fingByName(String name){
        return userDao.findByName(name);
    }


}
