package com.expensemanagement.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensemanagement.dao.BudgetRepository;
import com.expensemanagement.domain.Constants;
import com.expensemanagement.pojo.Budget;

@Service
public class BudgetServiceImpl implements BudgetService{
	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public List<Budget> findByUserId(Integer userId) {
		return budgetRepository.findByUserId(userId);
	}

	@Override
	public Map<String, Object> addBudgetForUser(Integer userId, String budgetDate, BigDecimal amount, boolean isMonthly) {
		Map<String, Object> resp = new HashMap<>();
		Budget budget = new Budget();
		Timestamp timeStamp = Timestamp.valueOf(budgetDate);
		budget.setBudgetDate(new Date(timeStamp.getTime()));
		budget.setAmount(amount);
		budget.setMonthly(isMonthly);
		budget.setUserId(userId);
		budget.setCreatedDate(new Date());
		budgetRepository.save(budget);
		resp.put(Constants.KEY_STATUS, 1);
		resp.put(Constants.KEY_MESSAGE, "Success");
		return resp;
	}
	
	
}
