package com.revature.users;

import java.io.Serializable;

import com.revature.util.CustomerFile;
import com.revature.util.FileStuff;
import com.revature.util.LogThis;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1954208440203798072L;
	
	private String firstName;
	private String lastName;
	private String address;
	private String username;
	private String password;
	private int accounts;
	
	public Customer() {
		super();
		CustomerFile.custMap.put(username, password);
		FileStuff.writeCustomerMap(CustomerFile.custMap);
		CustomerFile.custList.add(this);
		FileStuff.writeCustomerFile(CustomerFile.custList);
		LogThis.LogIt("info", "New customer account added.");
	}
	
	public Customer(String firstName, String lastName, String address, String username, String password, int accounts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
		CustomerFile.custMap.put(username, password);
		FileStuff.writeCustomerMap(CustomerFile.custMap);
		CustomerFile.custList.add(this);
		FileStuff.writeCustomerFile(CustomerFile.custList);
		LogThis.LogIt("info", "New customer account added.");
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccount() {
		return accounts;
	}

	public void setAccount(int accounts) {
		this.accounts = accounts;
	}
	
	public void addNumOfAccts(int x) {
		this.accounts+=x;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", username="
				+ username + ", password=" + password + ", account=" + accounts + "]";
	}
	
}
