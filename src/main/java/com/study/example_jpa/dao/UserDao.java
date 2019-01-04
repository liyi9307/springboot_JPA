package com.study.example_jpa.dao;


import com.study.example_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository< User, Integer>{

    List<User> findByName(String name);
}
