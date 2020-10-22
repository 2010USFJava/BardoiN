package com.revature.chaining;

public class Dog {
	
	private String name;
	private String gender;
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	private int age;
	
	public Dog() {
		this("Ollie");
	}
	public Dog(String name) {
		this(name, "male");
	}
	
	public Dog(String name, String gender) {
		this(name, gender, 40);
	}
	
	public Dog(String name, String gender, int numTeeth) {
		this(name, gender, numTeeth, 33);
	}
	
	public Dog(String name, String gender, int numTeeth, int numWhiskers) {
		this(name, gender, numTeeth, numWhiskers, 65);
	}
	
	public Dog(String name, String gender, int numTeeth, int numWhiskers, int weight) {
		this(name, gender, numTeeth, numWhiskers, weight, 7);
	}
		
	public Dog(String name, String gender, int numTeeth, int numWhiskers, int weight, int age) {	
		this.name = name;
		this.gender = gender;
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
		this.age = age;
	}

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d);

	}
	
	@Override
	public String toString() {
		return "Dog [name = " + name + ", gender = " + gender + ", numTeeth = " + numTeeth + ", numWhiskers = " + numWhiskers + ", weight = " + weight + ", age = " + age + "]";
	}

}
