package com.study.example_jpa.dao;

import com.study.example_jpa.entity.UserName;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = {"cache1"})
public interface UserNameDao extends JpaRepository<UserName, Integer> {
    @Cacheable
    List<UserName> findByName(String name);
}
