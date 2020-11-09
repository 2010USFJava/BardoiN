package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.users.AccountManager;
import com.revature.users.AccountManager.accountType;
import com.revature.users.Customer;

public class Testing {
	
	@BeforeClass
	public static void initial(){
		System.out.println("Starting testing...");
	}
	@BeforeClass
	public static void runBeforeTest() {
		System.out.println("Running before each test...");
	}
	
	static Customer customer1;
	static Customer customer2;
	static AccountManager check;
	static AccountManager save;
	static AccountManager jointAcc;
	
	@BeforeClass
	public static void loadAccts() {
		accountType checking = accountType.CHECKING;
		accountType savings = accountType.SAVINGS;
		accountType joint = accountType.JOINTCHECKING;
		customer1 = new Customer("first", "last", "1234 Nowhere St., Nowhere, USA 12345", "user", "pass", 2);
		customer2 = new Customer("first", "last", "1234 Nowhere St., Nowhere, USA 12345", "user", "pass", 1);
		check = new AccountManager(customer1.getUsername(), null, 345689, checking,true, 125.0);
		save = new AccountManager(customer1.getUsername(), null, 234554, savings, true, 205.0);
		jointAcc = new AccountManager(customer1.getUsername(),customer2.getUsername(), 159753, joint, true, 500.0);
		System.out.println("Accounts Loaded"
				+ "\n" + check.toString() + ""
				+ "\n" + save.toString() + ""
				+ "\n"+ jointAcc.toString());
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void depositTest() {
		AccountManager.deposit(customer1, check);
		System.out.println(check.getBalance());
		assertEquals(125.0, check.getBalance());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void withdrawalTest() {
		AccountManager.withdraw(customer1, save);
		System.out.println(save.getBalance());
		assertEquals(205.0,save.getBalance());
	}
		

}