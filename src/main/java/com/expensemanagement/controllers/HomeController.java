package com.expensemanagement.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.expensemanagement.dao.ExpenseRepository;
import com.expensemanagement.pojo.Budget;
import com.expensemanagement.pojo.Category;
import com.expensemanagement.pojo.Expense;
import com.expensemanagement.pojo.User;
import com.expensemanagement.services.BudgetService;
import com.expensemanagement.services.CategoryService;
import com.expensemanagement.services.UserService;

@RestController
public class HomeController {
	final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BudgetService budgetService;
	
	@RequestMapping(value="/getAllCategories")
	public Iterable<Category> getAllCategories(){
		return categoryService.findAll();
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile multipart, @RequestParam("budgetId") String budgetId,
			@RequestParam("categoryId") String categoryId) {
	    try {
	        Expense expense = new Expense();
	        expense.setUserId(1);
	        expense.setBudgetId(budgetId);
	        expense.setCategoryId(categoryId);
	        expense.setAmount(new BigDecimal(10000));
	        expense.setDescription("Just Demo");
	        expense.setCreatedDate(new Date());
	        expense.setBill(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
	        expenseRepository.insert(expense);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "failure";
	    }
	    return "success";
	}
	
	@PostMapping("/retrieve")
	public String retrieveFile(@RequestParam("id") String id){
	    Optional<Expense> demoDocument = expenseRepository.findById(id);
	    Expense expense = demoDocument.get();
	    Binary document = expense.getBill();
	    if(document != null) {
	        FileOutputStream fileOuputStream = null;
	        try {
	            fileOuputStream = new FileOutputStream("E:/bill.jpg");
	            fileOuputStream.write(document.getData());
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "failure";
	        } finally {
	            if (fileOuputStream != null) {
	                try {
	                    fileOuputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    return "failure";
	                }
	            }
	        }
	    }
	    
	    return "success";
	}
	
	@RequestMapping(value="/getBudgetHistoryByUser")
	public Page<Budget> getBudgetHistoryByUser(HttpServletRequest request){
		User user = userService.getCurrentLoggedInUser(request);
		return new PageImpl<>(budgetService.findByUserId(user.getId())); 
	}
	
	@RequestMapping(value="/addBudgetForUser",method=RequestMethod.POST)
	public Map<String, Object> addBudgetForUser(HttpServletRequest request, String budgetDate, BigDecimal amount, boolean isMonthly){
		User user = userService.getCurrentLoggedInUser(request);
		System.out.println("UserId "+user.getId());
		return budgetService.addBudgetForUser(user.getId(), budgetDate, amount, isMonthly);
	}
}
