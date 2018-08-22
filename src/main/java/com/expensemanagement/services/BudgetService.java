package com.expensemanagement.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.expensemanagement.pojo.Budget;

public interface BudgetService {
	public List<Budget> findByUserId(Integer userId);
	
	public Map<String, Object> addBudgetForUser(Integer userId,String budgetDate,BigDecimal amount,boolean isMonthly);
}
