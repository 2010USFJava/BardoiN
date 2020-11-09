package com.revature.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.revature.menu.Menu;
import com.revature.users.AccountManager;
import com.revature.users.Customer;

public class CustomerFile {
	public static List<Customer> custList = new ArrayList<>();
	public static Map<String,String> custMap = new HashMap<>();
	public static List<AccountManager> acctList = new ArrayList<>();
	public static Set<Integer> acctNumbers = new HashSet<>();
	
	public static Customer findCustByUser(String username) {
		for(int i = 0; i < custList.size();i++) {
			String name = custList.get(i).getUsername();
			if(username.equals(name)) {
				return custList.get(i);
			}
		}
		System.err.println("Customer not found.");
		Menu.mainMenu();
		return null;
	}
	
	public static int accountNumber() {
		int accNum = (int) (Math.random()*100000);
		if(acctNumbers.contains(accNum)==true) {
			accountNumber();
		}else {
			acctNumbers.add(accNum);
		}
		return accNum;
	}
	
	public static AccountManager findAcctByNumber(int num) {
		for(int i = 0; i < acctList.size(); i++) {
			int acctNum = acctList.get(i).getAccountNumber();
			if(num==acctNum) {
				return acctList.get(i);
			}
		}
		System.err.println("Account not found.");
		Menu.mainMenu();
		return null;
	}
	
	public static void findAcctsByUser(String user) {
		for(int i = 0; i < acctList.size(); i++) {
			AccountManager acct = acctList.get(i);
			if(acct.getUsername().equals(user)) {
				System.out.println("\n["+(i+1)+"]" + acct);
				break;
			}else if(acct.getJointUser().equals(user)) {
				System.out.println("\n["+(i+1)+"]" + acct);
				break;
			}else {
				System.out.println("This user has no accounts.");
				break;
			}
		}
	}
}
