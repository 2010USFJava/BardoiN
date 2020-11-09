package com.revature.users;

import java.io.Serializable;

import com.revature.util.EmployeeFile;
import com.revature.util.FileStuff;
import com.revature.util.LogThis;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7532638298861401827L;

	private String username;
	private String password;
	
	public Employee() {
		super();
		EmployeeFile.empMap.put(username,password);
		FileStuff.writeEmployeeFile(EmployeeFile.empMap);
		System.out.println("New employee created.");
		LogThis.LogIt("info", "New employee '" + this.getUsername() + "' created.");
	}
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		EmployeeFile.empMap.put(username,password);
		FileStuff.writeEmployeeFile(EmployeeFile.empMap);
		System.out.println("New employee created.");
		LogThis.LogIt("info", "New employee '" + this.getUsername() + "' created.");
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
	
	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}
}
