package com.myproject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myproject.pojo.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
