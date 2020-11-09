package com.revature.compare;

public class Student implements Comparable<Student>{
	// 1st method of comparing
	private int studentID;
	private String label;
	private double gpa;
	
	public Student() {
		super();
	}
	
	public Student(int studentID, String label, double gpa) {
		super();
		this.studentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
