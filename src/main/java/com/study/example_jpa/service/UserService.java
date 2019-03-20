package com.study.example_jpa.service;

import com.study.example_jpa.dao.UserDao;
import com.study.example_jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void saveUser(User user){
        userDao.save(user);
    }

    public Optional<User> findById(int id){
        return userDao.findById(id);
    }

    public List<User> fingByName(String name){
        return userDao.findByName(name);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
    /* JPA一级缓存(hibernate session 缓存)
    *  不用其它配置
    * */
    public User sessionCache(){

        System.out.println("-------------------------");
        User user1 = entityManager.find(User.class, 1);
        System.out.println("-------------------------");

        /* 如果不是同一个entityManager的话，就不会发生session缓存 */
        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();

        /* 缓存中有数据，直接从缓存中取数据 */
        User user2 = entityManager.find(User.class, 1);
        System.out.println("-------------------------");
        return user1;
    }

}
