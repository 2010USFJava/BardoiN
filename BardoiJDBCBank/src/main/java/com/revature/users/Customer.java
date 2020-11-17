package com.revature.users;

import java.io.Serializable;

import com.revature.util.LogThis;

//import com.revature.util.CustomerFile;
//import com.revature.util.FileStuff;
//import com.revature.util.LogThis;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8510818702688085944L;
	
	private int user_id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private String email;
	private String phone;
	private String username;
	private String password;
	
	public Customer() {
		super();
	}
	
	public Customer(int user_id, String firstName, String lastName, String address, String city, String state, int zipcode, String email, String phone, String username, String password) {
		super();
		
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	@Override
	public String toString() {
		return "Customer"
				+ "\nUSER_ID = " + user_id
				+ "\nFirst Name = " + firstName
				+ "\nLast Name = " + lastName
				+ "\nAddress = " + address
				+ "\nCity = " + city
				+ "\nState = " + state
				+ "\nZip Code = " + zipcode
				+ "\nEmail Address = " + email
				+ "\nPhone Number = " + phone
				+ "\nUsername = " + username
				+ "\nPassword = " + password;
	}

	
}
