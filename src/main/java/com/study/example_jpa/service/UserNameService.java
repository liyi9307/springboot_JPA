package com.study.example_jpa.service;



import com.study.example_jpa.dao.UserNameDao;

import com.study.example_jpa.entity.UserName;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Service
public class UserNameService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserNameDao userNameDao;

    /* 二级缓存是跨entityManager的缓存
     *  这里使用ehcache
     *  在Application上开启缓存@EnableCaching
     *  在接口方法山加@CacheConfig和@Cacheable
     *
     *
     * */

    public List<UserName> secondCache(String name){
        System.out.println("-------------------------");
        List<UserName> userName1 = userNameDao.findByName(name);
        System.out.println("-------------------------");
        /* 就算不是同一个entityManager，也进行了缓存，现象就是只打印一条查询语句 */
        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();

        List<UserName> userName2 = userNameDao.findByName(name);
        System.out.println("-------------------------");
        return userName1;
    }


}
