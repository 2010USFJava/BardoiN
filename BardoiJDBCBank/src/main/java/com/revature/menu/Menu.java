package com.revature.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.revature.daoimpl.AccountsDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.users.Accounts;
import com.revature.users.Accounts.accountType;
import com.revature.users.Admin;
import com.revature.users.Customer;
import com.revature.util.LogThis;

public class Menu {
	
	static int option;
	static DecimalFormat df = new DecimalFormat("#.00");
	
	static Scanner sc = new Scanner(System.in);
	
	public static void mainMenu() throws SQLException, IOException{
		System.out.println("\nWelcome to Byte Bank."
				+ "\nPlease select one of the options displayed below."
				+ "\n1) Register"
				+ "\n2) Customer login"
				+ "\n3) Admin login"
				+ "\n"
				+ "\n0) Exit");
		option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
		case 1: //register
			registerMenu();
			break;
		case 2: //customer login
			customerLogin();
			break;
		case 3: //admin login
			adminLogin();
			break;
		case 0: //exit
			System.out.println("Thank you for stopping by Byte Bank. Have a good day!");
			System.exit(0);
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			mainMenu();
		}
		
	}
	
	public static void registerMenu() throws SQLException, IOException{
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		System.out.println("Please enter your first name.");
		String firstName = sc.nextLine();
		System.out.println("Please enter your last name");
		String lastName = sc.nextLine();
		System.out.println("Please enter your street address.");
		String address = sc.nextLine();
		System.out.println("Please enter your city.");
		String city = sc.nextLine();
		System.out.println("Please enter your state.");
		String state = sc.nextLine();
		System.out.println("Please enter your zipcode.");
		int zipcode = Integer.parseInt(sc.nextLine());
		System.out.println("Please enter your email address.");
		String email = sc.nextLine();
		System.out.println("Please enter your phone number.");
		String phone = sc.nextLine();
		System.out.println("Please create a username.");
		String username = sc.nextLine();
		System.out.println("Please create a password.");
		String password = sc.nextLine();
		
		Customer cust = new Customer(0, firstName, lastName, address, city, state, zipcode, email, phone, username, password);
		
		try {
			cdi.createCustomer(cust);
			System.out.println("Account Created! \nWelcome! Please try logging in again with the username and password");
			System.out.println();
			
			LogThis.LogIt("info", "New customer account '" + cust.getUsername() + "' added.");

		} catch (SQLException e) {
			System.out.println("Username already exists");
			System.out.println("Could not create Account and add to database\nPlease try again later");
			e.printStackTrace();
		}
			mainMenu();

		}
	

	public static void customerLogin() throws SQLException, IOException {
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		System.out.println("\nCustomer Login"
				+ "\n----------------------------"
				+ "\nPlease enter your username.");
		String username = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		
		try {
			Customer cust = cdi.findCustomerbyLogin(username, password);

			LogThis.LogIt("info", "New customer '" + username + "' login.");
			customerFindAcct(cust);
			
		} catch (SQLException e) {
		e.printStackTrace();
		customerLogin();
		}
	}
	
	public static void customerMenu(Accounts acct) throws SQLException, IOException{
			CustomerDaoImpl cdi = new CustomerDaoImpl();
			
			AccountsDaoImpl adi = new AccountsDaoImpl();
			
			int custID = acct.getUser_id();
			int exitOpt = 0;
			
			Customer cust = cdi.getCustomerInfobyID(custID);
			
		System.out.println("\nHello " + cust.getFirstName());
		
		System.out.println("\nPlease select one of the options displayed below"
				+ "\n1) View Customer Info"
				+ "\n2) Apply for a new account"
				+ "\n3) Get account info"
				+ "\n4) Deposit"
				+ "\n5) Withdraw"
				+ "\n6) Delete account"
				+ "\n7) Switch account"
				+ "\n"
				+ "\n0) Logout");
		
		option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
		case 1: //view cust info
			System.out.println("Customer Info:"
					+ "\n" + cust.toString());
			
			System.out.println("\nPress 0 to return to the customer menu.");
				exitOpt = Integer.parseInt(sc.nextLine());
				if(exitOpt == 0) {
					customerMenu(acct);
				} else {
					System.out.println("Invalid option."
							+ "\nReturning to customer login");
					customerLogin();
				}
			
			break;
		case 2://Apply for account
			newAcctMenu(cust);
			break;
		case 3://view account info
			System.out.println("Account Info:"
					+ "\n" + acct.toString());
			
			System.out.println("\nPress 0 to return to the customer menu.");
			exitOpt = Integer.parseInt(sc.nextLine());
			if(exitOpt == 0) {
				customerMenu(acct);
			} else {
				System.out.println("Invalid option."
						+ "\nReturning to customer login");
				customerLogin();
			}
			
			break;
		case 4://deposit
			System.out.println("Please enter the numerical amount that you would like to deposit.");
			double deposit = Double.parseDouble(sc.nextLine());
			if(deposit < 0) {
				System.out.println("You cannot deposit a negative amount."
						+ "\nReturning to the customer menu....");
				customerMenu(acct);
			}else System.out.println("Do you want to deposit $" + deposit +"? Please type 'yes' to confirm."); {
				String dep = sc.nextLine();
				if(dep.equalsIgnoreCase("yes")) {
					adi.deposit(acct, deposit);
					
					double balance = adi.getBalance(acct);
					System.out.println("Account ID = " + acct.getBankAccountID()
					+ "\nUpdated Balance = " + balance);

					LogThis.LogIt("info", cust.getUsername() +" has deposited $" + deposit + " into account " + acct.getBankAccountID() + ".");
					customerMenu(acct);
				} else System.out.println("Invalid Ammount."
						+ "\nReturning to the customer menu....");
				customerMenu(acct);
			}
			break;
		case 5://withdraw
			double prevBal = adi.getBalance(acct);
			System.out.println("Please enter the numerical amount that you would like to withdraw.");
			double withdraw = Double.parseDouble(sc.nextLine());
			if(withdraw > prevBal) {
				System.out.println("You cannot withdraw an amount greater than your current balance of $" + prevBal + "."
						+ "\nReturning to the customer menu....");
				customerMenu(acct);
			}else System.out.println("Do you want to withdraw $" + withdraw +"? Please type 'yes' to confirm."); {
				String dep = sc.nextLine();
				if(dep.equalsIgnoreCase("yes")) {
					adi.withdraw(acct, withdraw);
					
					double balance = adi.getBalance(acct);
					System.out.println("Account ID = " + acct.getBankAccountID()
					+ "\nUpdated Balance = " + balance);

					LogThis.LogIt("info", cust.getUsername() +" has withdrawn $" + withdraw + " from account " + acct.getBankAccountID() + ".");
					customerMenu(acct);
				} else System.out.println("Invalid Ammount."
						+ "\nReturning to the customer menu....");
				customerMenu(acct);
			}
			break;
		case 6: //delete account
			deleteAcct(acct);
			break;
		case 7: //switch account
			List<Accounts> acctList = (ArrayList<Accounts>)adi.getAllAccounts(cust);
			
			System.out.println("Your accounts are displayed below. Please enter the Account ID of the account you would like to access."
					+ "\nPress 0 to exit.");
						
			for(int i = 0; i < acctList.size(); i++) {
				Accounts acct1 = acctList.get(i);
					System.out.println("\n["+(i+1)+"]" + acct1);
			}

			option = Integer.parseInt(sc.nextLine());
			if(option==0) {
				System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
						+ "\n"
						+ "\nYou are being redirected to the main menu.");
				customerMenu(acct);
			}else {
				
				Accounts acct1 = adi.getAccountbyID(option);
				customerMenu(acct1);
				
			}
			break;
		case 0://exit
			System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
					+ "\n"
					+ "\n You are being redirected to the main menu.");
			LogThis.LogIt("info", cust.getUsername() +" has logged out.");
			mainMenu();
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			customerMenu(acct);
		}
}
	
	public static void balance(Accounts acct) throws SQLException {
		AccountsDaoImpl adi = new AccountsDaoImpl();
		
		double balance = adi.getBalance(acct);
		System.out.println("Account Balance: " + balance);
	}
	
	
		public static void newAcctMenu(Customer cust) throws SQLException, IOException {
			CustomerDaoImpl cdi = new CustomerDaoImpl();
		
			AccountsDaoImpl adi = new AccountsDaoImpl();
			
			Accounts acct = null;
			Customer cust1 = null;
			
			
		System.out.println("\nPlease select what type of account you would like to apply for."
				+ "\n1. Checking Account"
				+ "\n2. Savings Account");
		
		option = Integer.parseInt(sc.nextLine());	
		accountType type = null;
		int custID = cust.getUser_id();;
		
		switch(option) {
		case 1:
			type = accountType.CHECKING;
			acct = new Accounts(0, custID, type, 0.0);
			adi.createAccount(acct);

			break;
		case 2:
			type = accountType.SAVINGS;
			acct = new Accounts(0, custID, type, 0.0);
			adi.createAccount(acct);
			
			break;
		default: 
			System.out.println("I'm sorry.I don't recognize that option please try again.");
		newAcctMenu(cust);
		}
		
		LogThis.LogIt("info", "A new " + acct.getType() + " account was applied for.");
		System.out.println("\n You are being redirected to the customer login.");
		customerLogin();
		}

	
	public static void customerFindAcct(Customer cust) throws SQLException, IOException {
		
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		
		AccountsDaoImpl adi = new AccountsDaoImpl();
		
		System.out.println(cust.toString());
		
		int custID = cust.getUser_id();
		
		List<Accounts> acctList = (ArrayList<Accounts>)adi.getAllAccounts(cust);
		
		int accts = acctList.size();
		
		System.out.println("\nHello " + cust.getFirstName());
		if(accts==0) {
			System.out.println("You have no accounts.");
			newAcctMenu(cust);
		} else {
			System.out.println("Your accounts are displayed below. Please enter the Account ID of the account you would like to access."
					+ "\nPress 0 to exit.");
						
			for(int i = 0; i < acctList.size(); i++) {
				Accounts acct1 = acctList.get(i);
					System.out.println("\n["+(i+1)+"]" + acct1);
			}

			option = Integer.parseInt(sc.nextLine());
			if(option==0) {
				System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
						+ "\n"
						+ "\nYou are being redirected to the main menu.");
				mainMenu();
			}else {
				
				Accounts acct = adi.getAccountbyID(option);
				customerMenu(acct);
			}
			}
		}
	
	public static void deleteAcct(Accounts acct) throws SQLException, IOException {
		
		AccountsDaoImpl adi = new AccountsDaoImpl();
				
		System.out.println("\n"
				+ "\nCurrent Account"+ acct.toString());
		
		double balance = adi.getBalance(acct);
		
		if(balance == 0.0) {
			System.out.println("This account has a balance of " + balance +".");
			System.out.println("\n"
					+ "\nWould you like to delete this account? Please type 'yes' to confirm.");
			String opt = sc.nextLine();
			if(opt.equalsIgnoreCase("yes")) {
				System.out.println("\nAccount Deleted. You are being redirected to the customer login.");
				LogThis.LogIt("info", "A new " + acct.getBankAccountID() + " account was deleted.");
					adi.deleteCustAcct(acct);
				customerLogin();
				}else {
					System.out.println("\nInvalid answer. Returning to customer menu....");
					customerMenu(acct);
			} 
					
		}else {
				System.out.println("\nCannot delete account because account is not empty."
						+ "\nReturning to customer menu...");
				customerMenu(acct);
			}
	}
	
	public static void adminLogin() throws IOException, SQLException {
		
		System.out.println("Admin Login"
				+ "\n------------------------------------"
				+ "\nPlease enter your username.");
		String user = sc.nextLine();
		System.out.println("Please enter your password.");
		String pass = sc.nextLine();
		
		FileInputStream fis=new FileInputStream("database.properties");
		Properties p=new Properties (); 
        p.load (fis);
        
        String adminUser = (String)p.get("adminUser"); 
        String adminPass = (String)p.get("adminPass");
        
		if(user.equals(adminUser)&&pass.equals(adminPass)) {
			adminMenu();
		}
		else {
		System.out.println("This username/password combination was not found. Please try again.");
			adminLogin();
			}
		}

	
	public static void adminMenu() throws SQLException, IOException {
		System.out.println("Please select one of the options displayed below."
				+ "\n1) View Customer Accounts"
				+ "\n2) Create a new Customer Account"
				+ "\n3) Update a Customer Account"
				+ "\n4) Delete a Customer Account"
				+ "\n"
				+ "\n0) Exit");
		option = Integer.parseInt(sc.nextLine());
		switch(option) {
		case 1: //view customer accounts
			break;
		case 2: //create a new customer account
			break;
		case 3: //update customer account
			break;
		case 4: //delete customer account
			break;
		case 0: //exit
			break;
		default:
			mainMenu();
		
		}
	}
}
