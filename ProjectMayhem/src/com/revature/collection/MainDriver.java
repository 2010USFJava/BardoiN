package com.revature.collection;

import java.util.ArrayList;
import java.util.*;

public class MainDriver {

	public static void main(String[] args) {

		String[] arrayString; //declaration
		
		arrayString = new String [3]; //initialization
			
		arrayString[0]  = "Hello there!";
		
		int [][][][][] arrayInt = new int [3][3][10][3][3];
		
		arrayInt[0][0][0][0][1] = 1;	
//		System.out.println(arrayString[0]); //print out index 0 from arrayString
//		
		arrayString = new String[10];
		
//		for(String x: arrayString) {
//			System.out.println(x);
//		}
		
		for(int[][][][] x: arrayInt) {
			for(int[][][] y : x) {
				for(int[][] z : y) {
				}
			}
		}
		
		//With Arrays you have to iterate through the list manually and print out each element
		//Arrays can't be resized.
		
		//COLLECTIONS
		//LIST -is an interface
		//Like all interfaces, it does not have a constructor
		
		List<String> stringList = new ArrayList<>(); //We're missing the size
		stringList.add("Hi There");
		stringList.add("The End");
		stringList.add("Goodbye!");
		stringList.add(2, "number 21");
		
		stringList.listIterator();
		
		List<String> otherList = new LinkedList<>();
		
		otherList.add("Apples");
		otherList.add("Kiwi");
		otherList.add("Banana");
		
		
		// Collection<String> lisst = new ArrayList<>();
//		lisst.list;
//		
//		System.out.println(stringList);
//		System.out.println(otherList.get(2))
		
		System.out.println(stringList);
		
		
		// SETS
		
		//We don't have access via index/position
		//We also don't allow duplicates
		
		Set<Double> mySet = new HashSet<>();
		
		mySet.add(100.0);
		mySet.add(200.0);
		mySet.add(350.0);
		mySet.add(250.0);
		mySet.add(210.0);
		mySet.add(400.0);
		System.out.println(mySet.add(100.0)); //false - already exists
		System.out.println(mySet.add(500.0)); //true - does not exist
		
		
		System.out.println(mySet);
	}

}
