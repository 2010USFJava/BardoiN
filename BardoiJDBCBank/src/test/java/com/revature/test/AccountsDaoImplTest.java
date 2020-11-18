package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.revature.daoimpl.AccountsDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.users.Accounts;
import com.revature.users.Accounts.accountType;
import com.revature.users.Customer;
import com.revature.util.ConnFactory;

public class AccountsDaoImplTest {
	static AccountsDaoImpl adi = new AccountsDaoImpl();
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	static ConnFactory cf = ConnFactory.getInstance();
	static Connection conn = cf.getConnection();
	
	
	@After
	public void deleteNewAcctData() {
		try {
			PreparedStatement p = conn.prepareStatement("delete from \"Accounts\" where \"USER_ID\"='1'");
			p.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete problems");
			e.printStackTrace();
		}
	}
	@After
	public void deleteNewCustData() {
		try {
			PreparedStatement p = conn.prepareStatement("delete from \"Customers\" where \"username\"='testUser'");
			p.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete problems");
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateAccount() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			Accounts a = null;
			if(rs!=null) {
				while(rs.next()) {
					a = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
					System.out.println(a.toString());
				}
			}else {
				fail("Test failure");
		} 
			}catch (SQLException e) {
			System.out.println("testNewAcct problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllAccts() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			List<Accounts> acctList= adi.getAllAccounts(c);
			assertTrue(acctList.size() > 0);
			}catch (SQLException e) {
			System.out.println("testGetAllAccts problem");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAcctbyID() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			Accounts a = null;
			int acctID = 0;
			if(rs!=null) {
				while(rs.next()) {
					a = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
					acctID = a.getBankAccountID();
					//System.out.println(a.toString());
				}
				
				adi.getAccountbyID(acctID);
				PreparedStatement ps2 = conn.prepareStatement("select * from \"Accounts\" where \"BANK_ACCOUNT_ID\"=?");
				ps2.setInt(1, acctID);
				ResultSet rs2 = ps2.executeQuery();
				Accounts a2 = null;
				if(rs2!=null) {
					while(rs2.next()) {
						a2 = new Accounts(rs2.getInt(1),rs2.getInt(2), accountType.valueOf(rs2.getString(3)), rs2.getDouble(4));
						//System.out.println(a.toString());
					}}
				assertEquals(a.getBankAccountID(), a2.getBankAccountID());
			}}
		catch (SQLException e) {
			System.out.println("testNewCustomer problem");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestGetBalance() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs2 = ps.executeQuery();
			Accounts a2 = null;
			if(rs2!=null) {
				while(rs2.next()) {
					a2 = new Accounts(rs2.getInt(1),rs2.getInt(2), accountType.valueOf(rs2.getString(3)), rs2.getDouble(4));
					//System.out.println(a.toString());
				}}
			
				double balance = adi.getBalance(a2);
				assertEquals(acct.getBal(), balance, 0.02);
			}catch (SQLException e) {
			System.out.println("testNewCustomer problem");
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void TestDeposit() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			Accounts a = null;
			if(rs!=null) {
				while(rs.next()) {
					a = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
					//System.out.println(a.toString());
				}}
				
				double deposit = 100.0;
				adi.deposit(a, deposit);
				
				PreparedStatement ps2 = conn.prepareStatement("update \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?");
				ps2.setInt(1, a.getBankAccountID());
				ResultSet rs2 = ps.executeQuery();
				double balance = 0.0;
				Accounts a2 = null;
				if(rs!=null) {
					while(rs.next()) {
						a2 = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
						//System.out.println(a.toString());
					}}
				assertEquals(100.00,a2.getBal(),.02);
			}catch (SQLException e) {
			System.out.println("testDeposit problem");
		}
	}
	
	@Test
	public void TestWithdraw() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 200.0);
			adi.createAccount(acct);
			
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			Accounts a = null;
			if(rs!=null) {
				while(rs.next()) {
					a = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
					//System.out.println(a.toString());
				}}
				
				double withdraw = 100.0;
				adi.withdraw(a, withdraw);
				
				PreparedStatement ps2 = conn.prepareStatement("update \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?");
				ps2.setInt(1, a.getBankAccountID());
				ResultSet rs2 = ps.executeQuery();
				double balance = 0.0;
				Accounts a2 = null;
				if(rs!=null) {
					while(rs.next()) {
						a2 = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
						//System.out.println(a.toString());
					}}
				assertEquals(100.00,a2.getBal(),.02);
			}catch (SQLException e) {
			System.out.println("testWithdraw problem");
		}
	}

	@Test
	public void deleteAcct() {
		Customer cust = new Customer(0,"first","last","123 Test st, city, state, zip","email", "phone","testUser","testPass");
		Accounts acct = null;
		try {
			boolean test;
			cdi.createCustomer(cust);
			Customer c = cdi.findCustomerbyLogin(cust.getUsername(), cust.getPassword());
			int custID = c.getUser_id();
			acct = new Accounts(0, custID, accountType.CHECKING, 0.0);
			adi.createAccount(acct);
			PreparedStatement ps = conn.prepareStatement("select * from \"Accounts\" where \"USER_ID\"=?");
			ps.setInt(1, custID);
			ResultSet rs = ps.executeQuery();
			Accounts a = null;
			if(rs!=null) {
				while(rs.next()) {
					a = new Accounts(rs.getInt(1),rs.getInt(2), accountType.valueOf(rs.getString(3)), rs.getDouble(4));
					//System.out.println(a.toString());
				}}
			
			PreparedStatement ps2 = conn.prepareStatement("delete from \"Accounts\" where \"BANK_ACCOUNT_ID\"= ?");
			ps.setInt(1,a.getBankAccountID());
			ResultSet rs2 = ps.executeQuery();
			  if(rs2!=null) {
	                while(rs2.next()) {
	                    test = true;
	                }
	            }test = false;
	            assertEquals(false,test);
		} catch (SQLException e) {
			System.out.println("delete problems");
		}
	}
	
}
