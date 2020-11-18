package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Accounts;
import com.revature.users.Customer;

public interface AccountsDao {
	
	public void createAccount(Accounts acct) throws SQLException;
	List<Accounts> getAllAccounts(Customer cust) throws SQLException;
	public Accounts getAccountbyID(int option) throws SQLException;
	public double getBalance(Accounts a) throws SQLException;
	public void deposit(Accounts a, double deposit) throws SQLException;
	public void withdraw(Accounts a, double withdraw) throws SQLException;
	public void deleteCustAcct(Accounts a) throws SQLException;
	
	
}
