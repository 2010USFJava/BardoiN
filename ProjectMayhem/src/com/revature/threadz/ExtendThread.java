package com.revature.threadz;

public class ExtendThread extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("\t\t Hi-ExtendThread");
			}
	}
}
