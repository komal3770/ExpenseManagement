package com.expensemanagement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.expensemanagement.pojo.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
