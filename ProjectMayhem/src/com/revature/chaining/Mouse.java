package com.revature.chaining;

public class Mouse {
	
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	public Mouse() {
		
	}
	
	public Mouse(int numTeeth) {
		this(numTeeth, 2);
	}
	
	public Mouse(int numTeeth, int numWhiskers) {
		this(numTeeth, numWhiskers, 5);
	}
	
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}

	public static void main(String[] args) {
		Mouse m = new Mouse(47430);
		System.out.println(m);

	}
	
	@Override
	public String toString() {
		return "Mouse [numTeeth = " + numTeeth + ", numWhiskers = " + numWhiskers + ", weight = " + weight + "]";
	}

}
