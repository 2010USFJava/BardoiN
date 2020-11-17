package com.revature.users;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.users.Accounts.accountType;
//import com.revature.util.CustomerFile;
//import com.revature.util.FileStuff;
//import com.revature.util.LogThis;

public class Accounts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8862625839422599452L;
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#.00");
	
	private int bankAccountID;
	private int custID;
	public enum accountType {
		CHECKING("CHECKING"),
		SAVINGS("SAVINGS");
	private String acctType;
    private accountType(String atype) {
      this.acctType=atype;
    }
    @Override
    public String toString() {
        return acctType;
    }
	}
	public accountType type;
	private double balance;
	
	
	public Accounts() {
		super();
	}

	public Accounts(int bankAccountID, int custID, accountType type, double balance) {
		super();
		this.bankAccountID = bankAccountID;
		this.custID = custID;
		this.type = type;
		this.balance = balance;
	}
	
	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public int getUser_id() {
		return custID;
	}

	public void setUser_id(int custID) {
		this.custID = custID;
	}

	public accountType getType() {
		return type;
	}
	public void setAccountType(accountType type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return ""
				+ "\nAccount ID = " + bankAccountID
				+ "\nCust ID = " + custID
				+ "\nAccount Type = " + type
				+ "\nBalance = " + balance;
	}
}
