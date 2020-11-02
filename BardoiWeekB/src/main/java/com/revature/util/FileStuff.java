package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Person;

public class FileStuff {
	public static final String personFile = "personList.txt";

	// write method
	public static void writePersonFile(List<Person> pList) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(personFile));
			objectOut.writeObject(pList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// read method
	@SuppressWarnings("unchecked")
	public static void readPersonFile() {
		try {
			ObjectInputStream objectIn= new ObjectInputStream(new FileInputStream(personFile));
			Roster.personList=(ArrayList<Person>)objectIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
