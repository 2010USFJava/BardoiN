package com.revature.driver;

import com.revature.menu.Menu;
import com.revature.users.AccountManager;
import com.revature.users.Admin;
import com.revature.users.Customer;
import com.revature.users.Employee;
import com.revature.users.AccountManager.accountType;
import com.revature.util.FileStuff;

public class Driver {
	
	static {FileStuff.readCustomerMap();}
	static {FileStuff.readCustomerFile();}
	static {FileStuff.readAccountsList();}
	static {FileStuff.readEmployeeMap();}
	static {FileStuff.readAdminMap();}
	
	
	public static void main(String[] args) {
		new Customer("first", "last", "1234 Nowhere St., Nowhere, USA 12345", "user", "pass", 0);
		new AccountManager("user", null, 12345, accountType.CHECKING, true, 0.0);
		new Employee("employee","0000");
		new Admin("admin","0000");
		
		Menu.mainMenu();

	}

	

}
