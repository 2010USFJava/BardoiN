package com.revature.strings;

public class FunWithStrings {

	public static void main(String[] args) {
		String s = "dog";
		String a = "dog";
		System.out.println(s.hashCode());
		System.out.println(a.hashCode());
		a = a + "house";
		System.out.println(a.hashCode());		
		System.out.println(s.charAt(2));
	}

}
