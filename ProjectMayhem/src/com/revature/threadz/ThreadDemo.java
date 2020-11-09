package com.revature.threadz;

public class ThreadDemo {
	/*
	 * 2 ways to spin up a thread
	 * 1 - extend Thread and overwrite Run()
	 * 2 - Implement the Runnable interface and overwrite Run()
	 */

	public static void main(String[] args) {
		
		Thread extendThread = new ExtendThread(); 
		Thread implementThread = new Thread(new ImplementRunnable()); //state: new

		implementThread.setPriority(10);
		
		extendThread.start(); 
		implementThread.start(); //state runnable
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Hey Driver");
			}
	}
}
