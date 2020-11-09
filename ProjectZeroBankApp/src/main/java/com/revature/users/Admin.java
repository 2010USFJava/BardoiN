package com.revature.users;

import java.io.Serializable;

import com.revature.util.AdminFile;
import com.revature.util.FileStuff;
import com.revature.util.LogThis;

public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7869941590404672549L;

	private String username;
	private String password;
	
	public Admin() {
		super();
		AdminFile.adMap.put(username,password);
		FileStuff.writeAdminFile(AdminFile.adMap);
		LogThis.LogIt("info", "New admin created.");
	}
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		AdminFile.adMap.put(username,password);
		FileStuff.writeAdminFile(AdminFile.adMap);
		LogThis.LogIt("info", "New admin created.");
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
		return "Admin [username=" + username + ", password=" + password + "]";
	}
}
