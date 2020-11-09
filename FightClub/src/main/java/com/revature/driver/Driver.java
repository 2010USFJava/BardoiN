package com.revature.driver;

import com.revature.beans.Warrior;
import com.revature.util.FileStuff;
import com.revature.util.Roster;

public class Driver {

	public static void main(String[] args) throws ClassNotFoundException {
		FileStuff.readWarriorFile();
		Warrior mikey = new Warrior("1", 200, 4);
		Warrior steven = new Warrior("2", 150, 8);
		System.out.println(Roster.warriorList.toString());

	}

}