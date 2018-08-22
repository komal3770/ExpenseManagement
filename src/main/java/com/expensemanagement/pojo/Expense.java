package com.expensemanagement.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="expense")
public class Expense {
	@Id
	private String id;
	
	@Field(value="user_id")
	private Integer userId;
	
	@Field(value="budget_id")
	private String budgetId;
	
	@Field(value="category_Id")
	private String categoryId;
	
	private String description;
	
	private BigDecimal amount;
	
	@Field(value="created_date")
	private Date createdDate;
	
	private Binary bill;

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

	public String getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Binary getBill() {
		return bill;
	}

	public void setBill(Binary bill) {
		this.bill = bill;
	}
	
	
}
