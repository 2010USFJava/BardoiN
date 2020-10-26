package com.revature.flows;

public class LoopyLoops {
	
	public static void main (String[] args) {
		wileyWhile(10);
		dowileyWhile(3);
	}

	/* Enhanced for loop aka for each
	 * for (x:<Array or Collection>) {do thing}
	 * good for moving through collections, arrays, and other iterables
	 * more CPU efficient
	 * no issues w/index out of bounds - not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
	public static void main(int[] a) {
		
		for(int i:a) {
			System.out.println(i+5);
		}
		/*
		 *  for(int i=0;i<a.length;i++) {System.out.println(a[i]+5); }
		 */
	}
	
	/*While loops
	 * while(<Ccondition>) {<do something>}
	 * 
	 * do while
	 * do {<do thing>} do (<condition>)
	 */
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("Roll Tide in the while loop - " + i);
		}
	}
	
	public static void dowileyWhile(int i) {
		do {
			System.out.println("Do you feel like we do " + i);
			i++;
		} while(i<=10);
		//i++;
	}
}
