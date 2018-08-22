package com.expensemanagement.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection="budget")
public class Budget {
	@Id
	private String id;
	
	@Field(value="user_id")
	private Integer userId;
	
	@Field(value="budget_date")
	private Date budgetDate;
	
	@Field(value="amount")
	private BigDecimal amount;
	
	@Field(value="is_monthly")
	private boolean isMonthly;
	
	@Field(value="created_date")
	private Date createdDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getBudgetDate() {
		return budgetDate;
	}
	public void setBudgetDate(Date budgetDate) {
		this.budgetDate = budgetDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public boolean isMonthly() {
		return isMonthly;
	}
	public void setMonthly(boolean isMonthly) {
		this.isMonthly = isMonthly;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
