package com.revature.wrapperz;

public class Wrapperz {
	/*
	 * Character - char
	 * Boolean - boolean
	 * Byte - byte
	 * Short - short
	 * Integer - int
	 * Long - long
	 * Float - float
	 * Double - double
	 
	 * Auto-Boxing
	 * Boxing - implicit conversion from primitive to wrapper
	 * Unboxing - implicit conversion from wrapper to primitive
	 */
	static int myInt = 3;
	static Integer myInteger = 5;
	static Double myDouble = 45.93;
	
	public static int addEmUp(int a, int b) {
		return a+b;
	}

	public static void main(String[] args) {
		int result = addEmUp(myInt, myInteger);
		System.out.println(result);
		Integer i = 0;
		i = i.MAX_VALUE;
		System.out.println(i);
	}

}
