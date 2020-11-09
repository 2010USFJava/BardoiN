package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Warrior;
import com.revature.util.Roster;
public class FileStuff {
	
	public static final String warriorFile="warriorList.txt";
	
	//write method
		public static void writewarriorFile(List<Warrior> wList) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(warriorFile));
				objectOut.writeObject(wList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//read method
		@SuppressWarnings("unchecked")
		public static void readWarriorFile() throws ClassNotFoundException {
			try {
				ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(warriorFile));
				Roster.warriorList=(ArrayList<Warrior>)objectIn.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
