package com.revature.exceptions;

public class InvalidInput extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2408911835934944431L;
	public InvalidInput() {
		System.out.println("Invalid input. Please enter a number.");
	}
}
