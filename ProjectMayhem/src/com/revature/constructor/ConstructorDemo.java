package com.revature.constructor;

public class ConstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

class A {
	A() {
		System.out.println("inside A's Constructor");
	}
}
	
class B extends A {
	B() {
		System.out.println("inside B's Constructor");
	}
}

class C extends B {
	C() {
		System.out.println("inside C's Constructor");
	}
}

	
}
