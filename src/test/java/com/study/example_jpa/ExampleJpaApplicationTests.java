package com.study.example_jpa;

import com.study.example_jpa.entity.User;
import com.study.example_jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleJpaApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private EntityManager entityManager;
    @Test
    public void contextLoads() {
        userService.sessionCache();
    }

}
