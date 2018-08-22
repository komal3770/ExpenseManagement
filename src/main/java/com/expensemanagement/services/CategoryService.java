package com.expensemanagement.services;

import com.expensemanagement.pojo.Category;

public interface CategoryService {
	Iterable<Category> findAll();
}
