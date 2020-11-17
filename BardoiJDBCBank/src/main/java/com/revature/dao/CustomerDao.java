package com.revature.dao;

import java.sql.SQLException;

import com.revature.users.Customer;

public interface CustomerDao {

	void createCustomer(Customer cust) throws SQLException;

	
}
