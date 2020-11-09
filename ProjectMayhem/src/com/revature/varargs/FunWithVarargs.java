package com.revature.varargs;

/*
 * Overloading
 * Creating methods with the same name but different method signatures
 * (i.e. number of and types of parameters and different return types).
  
 * Overloading Order of Operations
 * 	- Exact Match
 * 	- Conversion - primitives/Objects casting themselves to other types
 * 				 - primitive to primitive or Object to object
 * - Boxing - Primitives/Objects will undergo Auto Boxing/Unboxing
 * - Varargs - 
 */




public class FunWithVarargs {
	//Variable Length Argument
	/*
	 * Method that will take in a variable number of arguments
	 * Automate and hide the process of creating and saving values into an array
	 * prior to invoking the method
	 * can be of any type
	 * Must be last parameter
	 */
	public static void main(String[] args) {
		vaTest(10, 6, 78, 321, 51436, 14354153, 5);
		vaTest();
	}

	static void vaTest(int ... v) {
		System.out.println("Number of Args is: " + v.length + "\nContents: ");
		for(int x:v) {
			System.out.println(x);
		}
	}
}
