package com.revature.generics;

/* Generics
 * using a type as parameter
 * write code that can handle diff types of objects
 * use angle brackets <> to dentote that something is a generic
 * Allows us to ensure type safety
 * adds stability and reusablity to our code
 * Placeholder(T, E, ?, etc.) - use instead of an explicit type
 */

 /*T - type
E - Element
K - Key
N - number
V - Value
? - wildcard
*/

public class Gen1<T> {
	//declare an object of Type T
	T object;
	
	//pass the constructor a reference to an object of Type T
	Gen1(T objectParameter) {
		object=objectParameter;
	}
	
	T getObject() {
		return object;
	}
}
