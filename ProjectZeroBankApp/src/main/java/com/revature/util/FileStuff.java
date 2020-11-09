package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import com.revature.users.AccountManager;

import com.revature.users.Customer;

public class FileStuff {
	//customer file
	public static final String customerFile = "customers.txt";
	//write
	public static void writeCustomerFile(List<Customer> custList) {
		try {
			ObjectOutputStream custListOut = new ObjectOutputStream(new FileOutputStream(customerFile));
			custListOut.writeObject(custList);
			custListOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read
	@SuppressWarnings("unchecked")
	public static void readCustomerFile() {
		try {
			ObjectInputStream custListIn = new ObjectInputStream(new FileInputStream(customerFile));
			CustomerFile.custList = (List<Customer>)custListIn.readObject();
			custListIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//customer login map
	public static final String customerMap = "customerMap.txt";
	//write
	public static void writeCustomerMap(Map<String, String> custMap) {
		try {
			ObjectOutputStream custMapOut = new ObjectOutputStream(new FileOutputStream(customerMap));
			custMapOut.writeObject(custMap);
			custMapOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read
	@SuppressWarnings("unchecked")
	public static void readCustomerMap() {
		try {
			ObjectInputStream custMapIn = new ObjectInputStream(new FileInputStream(customerMap));
			CustomerFile.custMap = (Map<String,String>)custMapIn.readObject();
			custMapIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//employee login map
	public static final String employeeMap = "employeeMap.txt";
	
	public static void writeEmployeeFile(Map<String,String> empMap) {
		try {
			ObjectOutputStream empMapOut = new ObjectOutputStream(new FileOutputStream(employeeMap));
			empMapOut.writeObject(empMap);
			empMapOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read
	@SuppressWarnings("unchecked")
	public static void readEmployeeMap() {
		try {
			ObjectInputStream empMapIn = new ObjectInputStream(new FileInputStream(employeeMap));
			EmployeeFile.empMap = (Map<String,String>)empMapIn.readObject();
			empMapIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//admin login map
	public static final String adminMap = "adminMap.txt";
	
	public static void writeAdminFile(Map<String,String> adMap) {
		try {
			ObjectOutputStream adminMapOut = new ObjectOutputStream(new FileOutputStream(adminMap));
			adminMapOut.writeObject(adMap);
			adminMapOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//read
	@SuppressWarnings("unchecked")
	public static void readAdminMap() {
		try {
			ObjectInputStream adminMapIn = new ObjectInputStream(new FileInputStream(adminMap));
			AdminFile.adMap = (Map<String,String>)adminMapIn.readObject();
			adminMapIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Accounts file
	public static final String accountList = "accountList.txt";
	//write
	public static void writeAccountsList(List<AccountManager> acctList) {
		try {
			ObjectOutputStream acctListOut = new ObjectOutputStream(new FileOutputStream(accountList));
			acctListOut.writeObject(acctList);
			acctListOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//read
	@SuppressWarnings("unchecked" )
	public static void readAccountsList() {
		try {
			ObjectInputStream acctListIn = new ObjectInputStream(new FileInputStream(accountList));
			CustomerFile.acctList = (List<AccountManager>)acctListIn.readObject();
			acctListIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
