package com.revature.beans;

import java.io.Serializable;

import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3683231129528902082L;
	private String name;
	private int age;
	private String job;
	private String countryOfOrigin;
	
	public Person() {
		super();
		Roster.personList.add(this);
		FileStuff.writePersonFile(Roster.personList);
	}
	
	public Person(String name, int age, String job, String countryOfOrigin) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.countryOfOrigin = countryOfOrigin;
		Roster.personList.add(this);
		FileStuff.writePersonFile(Roster.personList);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCountry() {
		return countryOfOrigin;
	}
	
	public void setCountry(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "\nPerson Name = " + name + ", Age = " + age + ", Job = " + job + ", Country of Origin = " + countryOfOrigin;
	}
	
}
