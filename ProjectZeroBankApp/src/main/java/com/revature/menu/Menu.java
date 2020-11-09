package com.revature.menu;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.users.AccountManager;
import com.revature.users.AccountManager.accountType;
import com.revature.users.Admin;
import com.revature.users.Customer;
import com.revature.users.Employee;
import com.revature.util.AdminFile;
import com.revature.util.CustomerFile;
import com.revature.util.EmployeeFile;
import com.revature.util.FileStuff;
import com.revature.util.LogThis;


public class Menu {
	
	static int option;
	static DecimalFormat df = new DecimalFormat("#.00");
	
	static Scanner sc = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("\nWelcome to Byte Bank."
				+ "\nPlease select one of the options displayed below."
				+ "\n1) Register"
				+ "\n2) Customer login"
				+ "\n3) Employee login"
				+ "\n4) Admin login"
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
		case 3: //employee login
			employeeLogin();
			break;
		case 4: //admin login
			adminLogin();
			break;
		case 0: //exit
			System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
					+ "\n"
					+ "\n You are being redirected to the main menu.");
			mainMenu();
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			mainMenu();
		}
		
	}
	
	public static void registerMenu() {
		System.out.println("Please enter your first name.");
		String firstName = sc.nextLine();
		System.out.println("Please enter your last name");
		String lastName = sc.nextLine();
		System.out.println("Please enter your address.");
		String address = sc.nextLine();
		System.out.println("Please create a username.");
		String newUser = sc.nextLine();
		if(CustomerFile.custMap.containsKey(newUser)==false) {
			System.out.println("This username is available.");
		}else {
			System.out.println("This username is not available. Please try a different username.");
			registerMenu();
		}
		System.out.println("Please create a password.");
		String newPass = sc.nextLine();
		
		new Customer(firstName, lastName, address, newUser, newPass, 0);
		System.out.println("Thank you for applying for a new account.");
		
		mainMenu();
		}
	

	public static void customerLogin() {
		System.out.println("Customer Login"
				+ "\n----------------------------"
				+ "\nPlease enter your username.");
		String username = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		if(CustomerFile.custMap.getOrDefault(username,"password").equals(password)) {
				Customer cust = CustomerFile.findCustByUser(username);
				customerFindAcct(cust);
			}
		else {
			System.out.println("This username/password combination was not found. Please try again.");
			customerLogin();
		}	
	}
	
	
	public static void customerFindAcct(Customer cust) {
		System.out.println("\nHello " + cust.getFirstName());
		if(cust.getAccount()==0) {
			newAcctMenu(cust);
		} else {
			System.out.println("Your accounts are displayed below. Please select the account you would like to access."
					+ "\nPress 0 to exit.");
		
			for(int i = 0; i < CustomerFile.acctList.size(); i++) {
				AccountManager acct1 = CustomerFile.acctList.get(i);
					System.out.println("\n["+(i+1)+"]" + acct1);
				}
			option = Integer.parseInt(sc.nextLine());
			if(option==0) {
				System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
						+ "\n"
						+ "\nYou are being redirected to the main menu.");
				mainMenu();
			}else {
				Customer a = CustomerFile.custList.get(option-1);
				a.toString();
				int b = CustomerFile.acctList.get(option-1).getAccountNumber();
				
				AccountManager acct1 = CustomerFile.findAcctByNumber(b);
				customerMenu(cust, acct1);
			}
		}
	}

	
	public static void customerMenu(Customer cust, AccountManager acct) {
		System.out.println("\nHello " + cust.getFirstName());
		
		System.out.println(acct);
		
		System.out.println("\nPlease select one of the options displayed below"
				+ "\n1) Apply for an account"
				+ "\n2) Check account balance"
				+ "\n3) Deposit"
				+ "\n4) Withdraw"
				+ "\n5) Transfer Funds"
				+ "\n"
				+ "\n0) Exit");
		
		option = Integer.parseInt(sc.nextLine());
		
		switch(option) {
	
		case 1://Apply for account
			newAcctMenu(cust);
			break;
		case 2://check account balance
			System.out.println("Your current balance is " + df.format(acct.getBalance()));
			customerMenu(cust, acct);
			break;
		case 3://deposit
			AccountManager.deposit(cust, acct);
			customerMenu(cust, acct);
			break;
		case 4://withdraw
			AccountManager.withdraw(cust, acct);
			customerMenu(cust, acct);
			break;	
		case 5://transfer
			AccountManager.transfer(cust);
			customerMenu(cust, acct);
			break;
		case 0://exit
			System.out.println("Thank you for stopping by Byte Bank. Have a good day!"
					+ "\n"
					+ "\n You are being redirected to the main menu.");
			mainMenu();
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			customerMenu(cust, acct);
		}
	}
	
	public static void employeeLogin() {
		System.out.println("Employee Login"
				+ "\n--------------------------------"
				+ "\nPlease enter your username.");
		String username = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		
		if(EmployeeFile.empMap.getOrDefault(username,"password").equals(password)) {
			employeeMenu(username);
		} else {
		System.out.println("This username/password combination was not found. Please try again.");
		employeeLogin();
		}
		
	}
	public static void employeeMenu(String username) {
		System.out.println("Please select one of the options displayed below"
				+ "\n1) Approve or Deny Accounts"
				+ "\n2) Customer Assistance"
				+ "\n"
				+ "\n0) Exit");
		option = Integer.parseInt(sc.nextLine());
		switch(option) {
		case 1://approve/deny accounts
			approveDeny(username);
			break;
		case 2://assist customer
			System.out.println("Please enter the customer's username.");
			String custUser = sc.nextLine();
			Customer cust = CustomerFile.findCustByUser(custUser);
			cust.toString();
			System.out.println("Please select one of the options displayed below."
					+ "\n1) View Account Information"
					+ "\n2) View Customer Information"
					+ "\n"
					+ "\n0) Exit");
			int option2 = Integer.parseInt(sc.nextLine());
			switch(option2) {
			case 1://view account info
				for(int i = 0; i < CustomerFile.acctList.size(); i++) {
					AccountManager acct1 = CustomerFile.acctList.get(i);
						System.out.println("\n["+(i+1)+"]" + acct1);
					}
				System.out.println("Press enter to return.");
				sc.nextLine();
				employeeMenu(username);
				break;
			case 2://view customer info
				for(int i = 0; i < CustomerFile.custList.size(); i++) {
					Customer acct1 = CustomerFile.custList.get(i);
						System.out.println("\n["+(i+1)+"]" + acct1);
					}
				System.out.println("Press enter to return.");
				sc.nextLine();
				employeeMenu(username);
				break;
			case 0://exit
				employeeMenu(username);
				break;
			default:
				System.out.println("I'm sorry. I don't recognize that option please try again.");
				employeeMenu(username);
			}
			break;
		case 0:
			System.out.println("You are being redirected to the main menu.");
			mainMenu();
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			employeeMenu(username);
		}
	}
	
	public static void adminLogin() {
		System.out.println("Admin Login"
				+ "\n------------------------------------"
				+ "\nPlease enter your username.");
		String username = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		
		if(AdminFile.adMap.getOrDefault(username,"password").equals(password)) {
		adminMenu(username);
		}
		else {
		System.out.println("This username/password combination was not found. Please try again.");
			adminLogin();
		}
	}
	
	public static void adminMenu(String username) {
		System.out.println("Please select one of the options displayed below."
				+ "\n1) Approve or Deny Accounts"
				+ "\n2) Manage Employee Accounts"
				+ "\n3) Manage Customer Accounts"
				+ "\n"
				+ "\n0) Exit");
		option = Integer.parseInt(sc.nextLine());
		switch(option) {
		case 1://approve/deny account
			approveDeny(username);
			break;
		case 2://employee management
			System.out.println("Please select one of the options displayed below."
					+ "\n1) View All Employees"
					+ "\n2) Add New Employee"
					+ "\n3) Delete Employee"
					+ "\n4) View All Admins"
					+ "\n5) Add New Admin"
					+ "\n6) Delete Admin"
					+ "\n"
					+ "\n0) Exit");
			int option2 = Integer.parseInt(sc.nextLine());
			switch(option2) {
			case 1://view employees
				System.out.println("Employee usernames and passwords:");
				System.out.println(EmployeeFile.empMap);
				adminMenu(username);
				break;
			case 2://add employee
				System.out.println("Enter the new employee's username:");
				String empUser = sc.nextLine();
				System.out.println("Enter the new employee's password:");
				String empPass = sc.nextLine();
				new Employee(empUser,empPass);
				adminMenu(username);
				break;
			case 3://delete employee
				System.out.println("Please enter the username of the employee you wish to delete:");
				String empDelete = sc.nextLine();
				if(EmployeeFile.empMap.containsKey(empDelete)==true) {
					System.out.println("Are you sure you want to delete the login for " + empDelete + "? Please confirm by typing yes.");
					String edcheck = sc.nextLine();
					if(edcheck.equalsIgnoreCase("yes")) {
						EmployeeFile.empMap.remove(EmployeeFile.empMap.get(empDelete));
						adminMenu(username);
					}
				}else {
					System.out.println("That username was not found. Please try again.");
					adminMenu(username);
				}
				break;
			case 4://view all admins
				System.out.println("Admin usernames and passwords:");
				System.out.println(AdminFile.adMap);
				adminMenu(username);
				break;
			case 5://add new admin
				System.out.println("Enter the new admin's username:");
				String adminUser = sc.nextLine();
				System.out.println("Enter the new admin's password:");
				String adminPass = sc.nextLine();
				new Admin(adminUser,adminPass);
				adminMenu(username);
				break;
			case 6://delete admin
				System.out.println("Please enter the username of the admin you wish to delete.");
				String adminDelete = sc.nextLine();
				if(AdminFile.adMap.containsKey(adminDelete)==true) {
					System.out.println("Are you sure you want to delete " + adminDelete + "? Please confirm by typing yes.");
					String adcheck = sc.nextLine();
					if(adcheck.equalsIgnoreCase("yes")) {
						AdminFile.adMap.remove(AdminFile.adMap.get(adminDelete));
						adminMenu(username);
					}
				}else {
					System.out.println("That username was not found. Please try again.");
					adminMenu(username);
				}
				break;
			case 0://exit
				adminMenu(username);
				break;
			default:
				System.out.println("I'm sorry. I don't recognize that option please try again.");
				adminMenu(username);
			}
			break;
		case 3://customer management menu
			System.out.println("Please enter the customer's username.");
			String custUser = sc.nextLine();
			Customer cust = CustomerFile.findCustByUser(custUser);
			cust.toString();
			System.out.println("Please select one of the options displayed below."
					+ "\n1) View Account Information"
					+ "\n2) View Customer Information"
					+ "\n3) Customer Transaction"
					+ "\n4) Cancel Customer Account"
					+ "\n"
					+ "\n0) Exit");
			int option3 = Integer.parseInt(sc.nextLine());
			switch(option3) {
			case 1://view account info
				CustomerFile.findAcctsByUser(custUser);
				System.out.println("Press enter to return.");
				sc.nextLine();
				adminMenu(username);
				break;
			case 2://view customer info
				for(int i = 0; i < CustomerFile.custList.size(); i++) {
					Customer acct1 = CustomerFile.custList.get(i);
						System.out.println("\n["+(i+1)+"]" + acct1);
					}
				System.out.println("Press enter to return.");
				sc.nextLine();
				adminMenu(username);
				break;
			case 3://customer transactions
				System.out.println("Please select which account to use. Press 0 to exit.");
				CustomerFile.findAcctsByUser(custUser);
				int option4 = Integer.parseInt(sc.nextLine());
				if(option4==0) {
					adminMenu(username);
				}else {
					AccountManager acct = CustomerFile.acctList.get(option4-1);
					System.out.println("What would you like to do?"
							+ "\n1) Check Account Balance"
							+ "\n2) Deposit"
							+ "\n3) Withdraw"
							+ "\n4) Initiate a Transfer"
							+ "\n"
							+ "\n0) Exit");
					int option5 = Integer.parseInt(sc.nextLine());
					switch(option5) {
					case 1://view balance
						System.out.println("Your current balance is " + df.format(acct.getBalance()));
						adminMenu(username);
						break;
					case 2://deposit
						AccountManager.deposit(cust, acct);
						adminMenu(username);
						break;
					case 3://withdraw
						AccountManager.withdraw(cust, acct);
						adminMenu(username);
						break;
					case 4://transfer
						AccountManager.transfer(cust);
						adminMenu(username);
						break;
					case 0://exit
						adminMenu(username);
						break;
					default:
						System.out.println("I'm sorry. I don't recognize that option please try again.");
						adminMenu(username);
					}
				}
				break;
			case 4://cancel customer account
				System.out.println("Please select which account to cancel. Press 0 to exit.");
				CustomerFile.findAcctsByUser(custUser);
				int deleteCust = Integer.parseInt(sc.nextLine());
				if(deleteCust==0) {
					adminMenu(username);
				}else {
					AccountManager acct = CustomerFile.acctList.get(deleteCust-1);
					System.out.println("Are you sure you want to cancel account " + acct.getAccountNumber() + "? Please confirm by typing yes.");
					String delete = sc.nextLine();
					if(delete.equalsIgnoreCase("yes")) {
						CustomerFile.acctList.remove(deleteCust-1);
						System.out.println("Account " + acct.getAccountNumber() + " has been deleted.");
						LogThis.LogIt("info", "Admin " + username + " has deleted customer account " + acct.getAccountNumber() + ".");
					}else adminMenu(username);
				}
				break;
			case 0://exit
				adminMenu(username);
				break;
			default: 
				System.out.println("I'm sorry. I don't recognize that option please try again.");
				adminMenu(username);
			}
			break;
		case 0://exit
			System.out.println("You are being redirected to the main menu.");
			mainMenu();
			break;
		default:
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			adminMenu(username);
			
		}
	}
	
	public static void newAcctMenu(Customer cust) {
		
		System.out.println("\nPlease select what type of account you would like to apply for."
				+ "\n1. Checking Account"
				+ "\n2. Savings Account"
				+ "\n3. Joint Checking Account");
		option = Integer.parseInt(sc.nextLine());	
		accountType type = null;
		int accNum = CustomerFile.accountNumber();
		
		switch(option) {
		case 1:
			type = accountType.CHECKING;
			AccountManager check = new AccountManager(cust.getUsername(),"no", accNum, type, false, 0.0);
			cust.addNumOfAccts(1);
			CustomerFile.acctList.add(check);
			FileStuff.writeAccountsList(CustomerFile.acctList);
			break;
		case 2:
			type = accountType.SAVINGS;
			AccountManager save = new AccountManager(cust.getUsername(),"no", accNum, type, false, 0.0);
			cust.addNumOfAccts(1);
			CustomerFile.acctList.add(save);
			FileStuff.writeAccountsList(CustomerFile.acctList);
			break;
		case 3:
			type = accountType.JOINTCHECKING;
			System.out.println("Please enter the username of the customer you would like to apply for a joint account with.");
			String jointUser = sc.nextLine();
			AccountManager joint = new AccountManager(cust.getUsername(),jointUser, accNum, type, false, 0.0);
			cust.addNumOfAccts(1);
			CustomerFile.acctList.add(joint);
			FileStuff.writeAccountsList(CustomerFile.acctList);
			break;
		default: 
			System.out.println("I'm sorry. I don't recognize that option please try again.");
			
			customerLogin();
		}
		
		LogThis.LogIt("info", "An account was applied for.");
		System.out.println("Thank you for applying for a new account. Your account must be approved by an employee."
				+ "\n"
				+ "\n You are being redirected to the main menu.");
		mainMenu();
		}
	
	public static void approveDeny(String username) {
		System.out.println("Please select the account to review. Press 0 to exit.");
		for(int i = 0; i < CustomerFile.acctList.size(); i++) {
			AccountManager acct = CustomerFile.acctList.get(i);
			if(acct.isAccountStatus()==false) {
				System.out.println("\n["+(i+1)+"]" + acct);
			}
		}
		option = Integer.parseInt(sc.nextLine());
		if(option==0) {
			if(EmployeeFile.empMap.containsKey(username)==true) {
				employeeMenu(username);
			}else if(AdminFile.adMap.containsKey(username)==true) {
				adminMenu(username);
			}
		}else {
			Customer a = CustomerFile.custList.get(option-1);
			a.toString();
			System.out.println("Would you like to approve this account? Please confirm by typing yes or no.");
			String approve = sc.nextLine();
			if(approve.equalsIgnoreCase("yes")) {
				CustomerFile.acctList.get(option-1).setAccountStatus(true);
				a.setAccount(a.getAccount()+1);
				System.out.println("You have approved this account.");
				LogThis.LogIt("info", "A " + CustomerFile.acctList.get(option-1).getType() + " account for " + a.getUsername() + " has been approved by " + username + ".");
				
				System.out.println("You are being redirected to the main menu.");
				mainMenu();
			}else if(approve.equalsIgnoreCase("no")) {
				System.out.println("You have denied this account.");
				CustomerFile.acctList.remove(option-1);
				LogThis.LogIt("info", "A " + CustomerFile.acctList.get(option-1).getType() + " account for " + a.getUsername() + " has been denied by " + username + ".");
				System.out.println("You are being redirected to the main menu.");
				mainMenu();
			}
		}
		
	}
}
