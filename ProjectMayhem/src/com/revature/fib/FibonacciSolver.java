package com.revature.fib;

public class FibonacciSolver {
		/* Common whiteborarding question - Fibonacci Sequence
		 * The Fibonacci numbers are a sequence of integers in which the first
		 * two elements are 0 & 1, and each following elements are the sum
		 * of the two preceding elements: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
		 */
	
	public static int fibonacciIteration(int nthNumber) {
		//use iterations -> loop
		int previousNumber = 0;
		int previouspreviousNumber = 0;
		int currentNumber = 1;
		
		for(int i=1; i<nthNumber; i++) {
			
			previouspreviousNumber=previousNumber;
			previousNumber=currentNumber;
			currentNumber = previouspreviousNumber + previousNumber;
			System.out.println(currentNumber);
		}
		return currentNumber;
	}
	
	public static int fibonacciRecursion(int nthNumber) {
		//use recursion
		if(nthNumber==0) {
			return 0;			
		} else if (nthNumber==1) {
			System.out.println(nthNumber);
			return nthNumber;
		}
		System.out.println(nthNumber);
		return fibonacciRecursion(nthNumber-1) + fibonacciRecursion(nthNumber-2);
		
	}
	public static void main(String[] args) {
		System.out.println(fibonacciIteration(5));
		System.out.println(fibonacciRecursion(5));
	}

}
