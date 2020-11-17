package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Accounts;
import com.revature.users.Customer;

public interface AccountsDao {
	
	void createAccount(Accounts acct) throws SQLException;

	List<Accounts> getAllAccounts(Customer cust) throws SQLException;
	
	
}
