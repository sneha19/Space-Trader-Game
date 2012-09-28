package edu.gatech.oad.antlab.person;

import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	public static String calc(String input) {
		if(input == null) throw new NullPointerException();
	  String temp = "";
	  String finalString = "";
	  Random r = new Random();
	  int loc;
	  while(input.length() >= 1)
	  {
		  loc = r.nextInt(input.length());
		  temp = input.substring(loc, loc+1);
		  finalString = finalString + temp;
		  input = input.substring(0, loc) + input.substring(loc + 1, input.length());
	  }
	  return finalString;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
	public static void main(String[] args)
	{
		System.out.println(calc("samarth"));
	}
}
