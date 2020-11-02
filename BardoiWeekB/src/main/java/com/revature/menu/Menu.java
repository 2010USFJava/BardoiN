package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Person;
import com.revature.util.LogThis;
import com.revature.util.Roster;

public class Menu {
	static String option;
	
	public static Scanner n= new Scanner(System.in);
	
	public static void menu() {
		
		System.out.println("Hello, welcome to the Person database!"
				+ "\nLet's add a new person to the Database."
				+ "\nPlease enter the new Person's name.");
		String name = n.nextLine();
		System.out.println("What is " + name + "'s age? Please enter a whole number.");
		int age = n.nextInt();
		System.out.println("What is " + name + "'s job? Please enter a one word job title.");
		String job = n.next();
		System.out.println("What state is " + name + " from? Please enter the state as one word. ");
		String countryOfOrigin = n.next();
		
		Person p = new Person(name, age, job, countryOfOrigin);
		
		LogThis.LogIt("info", p.getName() + " was added to the Person database!" );
		
		System.out.println(Roster.personList.toString());
		
		System.out.println("\nThank you for contibuting to the Person database! Goodbye!");
		Runtime.getRuntime().exit(0);
		}

}
				
