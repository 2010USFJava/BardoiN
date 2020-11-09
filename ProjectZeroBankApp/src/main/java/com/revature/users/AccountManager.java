package com.revature.users;

import java.io.Serializable;

import com.revature.util.CustomerFile;
import com.revature.util.FileStuff;
import com.revature.util.LogThis;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486604064964013774L;
	
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#.00");
	
	private String username;
	private String jointUser;
	private int accountNumber;
	public enum accountType {
		CHECKING,
		SAVINGS,
		JOINTCHECKING;
	}
	public accountType type;
	private boolean accountStatus = false;
	private double balance;
	
	
	public AccountManager() {
		super();
	}

	public AccountManager(String username, String jointUser, int accountNumber, accountType type, boolean accountStatus, double balance) {
		super();
		this.username = username;
		this.jointUser = jointUser;
		this.accountNumber = accountNumber;
		this.type = type;
		this.accountStatus = accountStatus;
		this.balance = balance;
		
		CustomerFile.acctList.add(this);
		FileStuff.writeAccountsList(CustomerFile.acctList);
		LogThis.LogIt("info", "A new account has been added.");
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJointUser() {
		return jointUser;
	}
	public void setJointUser(String jointUser) {
		this.jointUser = jointUser;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public accountType getType() {
		return type;
	}
	public void setAccountType(accountType type) {
		this.type = type;
	}
	public boolean isAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Accounts [Username = " + username + ", Joint User = " + jointUser + ", Account Number = " + accountNumber + ", Account Type = " + type
				+ ", Account Active? = " + accountStatus + ", Balance = " + balance + "]";
	}
	
	public static void deposit(Customer cust, AccountManager acct) {
		System.out.println("Please enter the amount that you would like to deposit.");
		double deposit = Double.parseDouble(sc.nextLine());
		if(deposit < 0) {
			System.out.println("You cannot deposit a negative number.");
			deposit(cust, acct);
		}else System.out.println("You want to deposit " + df.format(deposit) +"? Please type yes to confirm.");
			String dep = sc.nextLine();
			if(dep.equalsIgnoreCase("yes")) {
				acct.setBalance(acct.getBalance() + deposit);
				LogThis.LogIt("info", cust.getFirstName() + " " + cust.getLastName() +" has deposited " + df.format(deposit) + " into account " + acct.getAccountNumber() + ".");
			} else deposit(cust, acct);
	}
	
	public static void withdraw(Customer cust, AccountManager acct) {
		System.out.println("Please enter the amount that you would like to withdraw.");
		double withdrawal = Double.parseDouble(sc.nextLine());
		if(withdrawal < 0) {
			System.out.println("You cannot withdraw a negative amount.");
			withdraw(cust, acct);
		}else if(acct.getBalance() - withdrawal < 0) {
			System.out.println("You cannot withdraw a higher amount than your available balance.");
			withdraw(cust, acct);
		}else System.out.println("You want to withdraw " + df.format(withdrawal) +"? Please type yes to confirm.");
			String withdraw = sc.nextLine();
			if(withdraw.equalsIgnoreCase("yes")) {
				acct.setBalance(acct.getBalance() - withdrawal);
				LogThis.LogIt("info", cust.getFirstName() + " " + cust.getLastName() +" has withdrawn " + df.format(withdrawal) + " from account " + acct.getAccountNumber() + ".");
			} else withdraw(cust, acct);
	}
	
	public static void transfer(Customer cust) {
		AccountManager acct1 = null;
		AccountManager acct2 = null;
		System.out.println("Please select the account to transfer from.");
		CustomerFile.findAcctsByUser(cust.getUsername());
		
		int option1 = Integer.parseInt(sc.nextLine());
		System.out.println(cust);
		
		if(option1==0) {
			transfer(cust);
		}else if(option1 >CustomerFile.acctList.size()+1) {
			System.out.println("Invalid option.");
			transfer(cust);
		}else {
			acct1 = CustomerFile.acctList.get(option1-1);
		}
		System.out.println("Please select the account to transfer to.");
		CustomerFile.findAcctsByUser(cust.getUsername());
		int option2 = Integer.parseInt(sc.nextLine());
		if(option2==0) {
			transfer(cust);
		}else if(option2 > CustomerFile.acctList.size()+1) {
			System.out.println("Invalid option.");
			transfer(cust);
		}else {
			acct2 = CustomerFile.acctList.get(option2-1);
		}
		System.out.println("Please input the amount you want to transfer.");
		double amount = sc.nextDouble();
		if(amount < 0) {
			System.out.println("You can't transfer a negative number.");
			transfer(cust);
		}else if(amount > acct1.getBalance()) {
			System.out.println("You can't transfer a higher amount than your available balance. ");
			transfer(cust);
		}else if(amount != (double)amount) {
			System.out.println("Invalid option.");
		}else {
			acct1.setBalance(acct1.getBalance()-amount);
			acct2.setBalance(acct2.getBalance()+amount);
			System.out.println(amount + " was transferred from account " + acct1.getAccountNumber() + " to " + acct2.getAccountNumber() + ".");
			System.out.println(acct1.getAccountNumber() + " balance: " + acct1.getBalance());
			System.out.println(acct2.getAccountNumber() + " balance: " + acct2.getBalance());
			LogThis.LogIt("info", amount + " was transferred from account " + acct1.getAccountNumber() + " to " + acct2.getAccountNumber() + ".");
		}
	}
	
}
