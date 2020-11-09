package com.revature.sorthis;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] loadBadArray(int length) {
		int [] myArray = new int [length];
		
		for(int i = length-1; i >= 0; i--) {
			myArray[i] = length-i;
		}
		
		return myArray;
	}
	
	public static void mergeSort(int [] a) {
//		int [] a = {1, 6, 9, 11, 5, 2, 7, 8, 3, 10, 4}; 
		int n = a.length;
		
		int r = n/2;
		int l = n/2;
		
		int [] rArray = new int[(n + 1)/2];
		int [] lArray = new int[n - rArray.length];
		
		for (int i=0; i < n; i++) {
			if (i < rArray.length) {
                rArray[i] = a[i];
			} else {
                lArray[i - rArray.length] = a[i];
			}
		}
		
		System.out.println(Arrays.toString(rArray));
        System.out.println(Arrays.toString(lArray));
        
        
	}
	
	public static void main(String [] args) {
		mergeSort(loadBadArray(11));
	}
//	
//	public static int[] merge(int[]lArray,int[]rArray) {
//		
//		int newLength=lArray.length+rArray.length;
//		int rLength=rArray.length;
//		int rPos=0;
//		int lLength=lArray.length;
//		int lPos=0;
//		
//		int [] newArray=new int[newLength];
//		int filledPos=0;
//		
////		int loopNumber;
////		int smallerNumber;
////		if(rLength>lLength) {
////			loopNumber=rLength;
////			smallerNumber=lLength;
////		} else {
////			loopNumber=lLength;
////			smallerNumber=rLength;
////		}
//		for(int i=0;i<loopNumber;i++) {
//			if (i<smallerNumber) {
//				if (rLength<lLength) {
//					newArray[filledPos++]=rArray[i];
//					newArray[filledPos++]=lArray[i];				
//				} else {
//					newArray[filledPos++]=lArray[i];	
//					newArray[filledPos++]=rArray[i];				
//					
//				}
//				
//				
//			} else {
//				if(rLength>lLength) {
//					newArray[filledPos++]=rArray[i];
//				} else {
//					newArray[filledPos++]=lArray[i];
//				}
//			}
//			
//		}
//		
//		return newArray;
//		
//	}

}
