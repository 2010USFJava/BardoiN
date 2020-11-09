package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
						new Student(9, "Matt", 7.22),
						new Student(18, "Heermancer", 3.98),
						new Student(27, "Esrat", 50.99),
						new Student(3, "Mike", 0.9),
						new Student(2, "Nadjah", 3.5),
						new Student(151, "Anna", 4.0),
						new Student(70, "Isa", 4.1),
						new Student(500000, "Jennifer the Hunter", 20.20)
				}));
		System.out.println("Original List");
		for(Student s: studentList) {
			System.out.println(s);
		}
		System.out.println("=====================");
	}

}
