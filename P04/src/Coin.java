//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Instance class for the Coin enumeration
// Files: Coin.java, ExceptionalBank.java, ExceptionalBankTester.java
// Course: CS 300 Spring 2020
//
// Author: Joseph O'Connell
// Email: jpoconnell2@wisc.edu
// Lecturer's Name: Gary Dahl
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
/**
 * This enum represents an enumeration of the US Currency Coin constants
 * 
 * @author Mouna
 *
 */
public enum Coin {
  PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

  private final int value; // value of this coins

  /**
   * The constructor for an enum type must be package-private or private access. This private
   * constructor is only used to create the constants that are defined at the beginning of this
   * enumeration's body.
   * 
   * @param value value in cents of this coin
   */
  private Coin(int value) {
    this.value = value;
  }

  /**
   * Returns the value in cents of this coin
   * 
   * @return the value of this coin
   */
  public int value() {
    return value;
  }

}