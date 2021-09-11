//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Coin instance methods for ElasticBank.java
// Files: ElasticBank.java, ElasticTester.java, Coin.java
// Course: CS 300 Spring 2020
//
// Author: Joseph O'Connell
// Email: jpoconnell2@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Joshua Niesen
// Partner Email: jsniesen@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understood the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
public class Coin {
	private String name;
	private int value;
	
	/**
	 * constructor for the coin object
	 * @param name
	 * @param value
	 */
  public Coin(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
  /**
   * gets the name of the coin object
   * @return string reference of the name
   */
	public String getName() {
		return this.name;
	}
	
	/**
   * gets the value of the coin object
   * @return  int number of the value
   */
	public int getValue() {
		return this.value;
	}
}
