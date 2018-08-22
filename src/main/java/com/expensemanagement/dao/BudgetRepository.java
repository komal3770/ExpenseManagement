package com.expensemanagement.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expensemanagement.pojo.Budget;

public interface BudgetRepository extends MongoRepository<Budget, String>{
	List<Budget> findByUserId(Integer userId);
}
