package com.expensemanagement.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@Field(value="email_id")
	private String emailId;
	
	@Field(value="mobile_no")
	private String mobileNo;
	
	private String password;
	
	@Field(value="created_date")
	private Date createdDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
