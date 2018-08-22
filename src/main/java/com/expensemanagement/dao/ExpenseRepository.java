package com.expensemanagement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.expensemanagement.pojo.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{

}
