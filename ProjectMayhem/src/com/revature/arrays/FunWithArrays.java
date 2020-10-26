package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {
// group of like-typed variables that are referred to by a common name
	public static void main(String[] args) {
		//int array w/ 7 "buckets"
		int myArray[] = new int [7];
		
		//int array with hardcoded values
		int [] chaos = {1, 2, 3, 4, 5, 6, 7, 8};
		//arrays start at index 0
		Arrays.sort(chaos);
//		System.out.println(chaos[7]);
		System.out.println(Arrays.toString(chaos));
	}

}
