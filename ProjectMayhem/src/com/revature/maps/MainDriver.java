package com.revature.maps;


import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class MainDriver {

	public static void main(String[] args) {
		//MAPS
		//Is an object that maps 'keys' to 'values' (also known as dictionary in other languages). Each key has to be unique and can be mapped to
		//only one value. Not that a key can be mapped to duplicate values.
		
		Map<String, String> myMap = new HashMap();
		
		myMap.put("Apples", "A Red or Green thing");
		myMap.put("Earth", "A blue thing");
		
//		System.out.println(myMap);
		System.out.println(myMap.get("Apples"));
		
		Map<Key, String> specialMap = new HashMap<>();
	
		Key myKey = new Key("Mercury");
		
		specialMap.put(myKey, "My key to Mercury");
	
	}

}
