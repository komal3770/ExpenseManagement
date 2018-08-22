package com.expensemanagement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.expensemanagement.pojo.Category;
@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{

}
