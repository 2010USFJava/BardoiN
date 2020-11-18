package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Customer;

public interface CustomerDao {

	public void createCustomer(Customer cust) throws SQLException;
	public Customer findCustomerbyLogin(String username, String password) throws SQLException;
	public Customer getCustomerInfobyID(int custID) throws SQLException;
	List<Customer> getAllCustomers() throws SQLException;
	public Customer updateFirstNamebyID(String newVal, int custID) throws SQLException;
	public Customer updateLastNamebyID(String newVal, int custID) throws SQLException;
	public Customer updateAddressbyID(String newVal, int custID) throws SQLException;
	public Customer updateEmailbyID(String newVal, int custID) throws SQLException;
	public Customer updatePhonebyID(String newVal, int custID) throws SQLException;
	public void deleteCust(int custID) throws SQLException;
	
}
