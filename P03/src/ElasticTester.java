//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: A testing file to test the functionality of ElasticBank.java and Coin.java
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
public class ElasticTester {

  /**
   * Checks whether Coin.java works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCoinInstantiableClass() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    if (!penny.getName().equals("PENNY"))
      return false;
    if (penny.getValue() != 1)
      return false;
    if (!quarter.getName().equals("QUARTER"))
      return false;
    if (quarter.getValue() != 25)
      return false;
    return true;
  }

  /**
   * Checks whether Coin.java and ElasticBank.java works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetCoins() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    ElasticBank bank = new ElasticBank();
    bank.addCoin(penny);
    bank.addCoin(quarter);
    return true;
  }

  /**
   * Checks whether getBalance() method works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBalanceAccessors() {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    if (one.getBalance() != 1)
      return false;
    if (two.getBalance() != 5)
      return false;
    return true;
  }

  /**
   * Checks whether the removeCoin() method works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoin() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    Coin dime = new Coin("DIME", 10);
    Coin nickel = new Coin("NICKEL", 5);
    ElasticBank removeTest = new ElasticBank(6);
    // Scenario 1 - the piggy bank is already empty with no values
    removeTest.removeCoin();
    if (removeTest.getSize() != 0) {
      System.out.println("Scenario 1: Problem detected. Your ElasticBank.removeCoin() did not"
          + "return the expected output.");
      return false;
    }
    // Scenario 2 - the piggy bank has one value to remove
    removeTest.addCoin(quarter);
    removeTest.removeCoin();
    if (removeTest.getSize() != 0) {
      System.out.println("Scenario 2: Problem detected. Your ElasticBank.removeCoin() did not"
          + "return the expected output.");
      return false;
    }
    // Scenario 3 - the piggy bank has multiple values to remove
    removeTest.addCoin(quarter);
    removeTest.addCoin(penny);
    removeTest.addCoin(nickel);
    removeTest.addCoin(dime);
    removeTest.addCoin(quarter);
    removeTest.addCoin(nickel);
    removeTest.removeCoin();
    removeTest.removeCoin();
    if (removeTest.getSize() != 4) {
      System.out.println("Scenario 3: Problem detected. Your ElasticBank.removeCoin() did not"
          + "return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the empty() method works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testEmpty() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    Coin dime = new Coin("DIME", 10);
    Coin nickel = new Coin("NICKEL", 5);
    ElasticBank emptyTest = new ElasticBank(6);
    // Scenario 1 - the piggy bank is already empty with no values
    emptyTest.removeCoin();
    if (emptyTest.getSize() != 0) {
      System.out.println("Scenario 1: Problem detected. Your ElasticBank.empty() did not"
          + "return the expected output.");
      return false;
    }
    // Scenario 2 - the piggy bank has one value to empty
    emptyTest.addCoin(quarter);
    emptyTest.empty();
    if (emptyTest.getSize() != 0) {
      System.out.println("Scenario 2: Problem detected. Your ElasticBank.empty() did not"
          + "return the expected output.");
      return false;
    }
    // Scenario 3 - the piggy bank has multiple values to empty
    emptyTest.addCoin(quarter);
    emptyTest.addCoin(penny);
    emptyTest.addCoin(nickel);
    emptyTest.addCoin(dime);
    emptyTest.addCoin(quarter);
    emptyTest.addCoin(nickel);
    emptyTest.empty();
    if (emptyTest.getSize() != 0) {
      System.out.println("Scenario 3: Problem detected. Your ElasticBank.empty() did not"
          + "return the expected output.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether the addCoin() method works as expected.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoin() {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    Coin dime = new Coin("DIME", 10);
    Coin nickel = new Coin("NICKEL", 5);
    ElasticBank addCoinTest = new ElasticBank(0); // Need to talk to Joe about this scenario and how
                                                  // to fix
    // Scenario 0 - the piggy bank size = 0 and want to add a coin
    addCoinTest.addCoin(penny);
    if (addCoinTest.getSize() != 1) {
      System.out.println("Scenario 0: Problem detected. Your ElasticBank.addCoin() did not"
          + "return the expected output.");
      return false;
    }

    addCoinTest = new ElasticBank(3);
    System.out.println("Original Size: " + addCoinTest.getSize());
    // Scenario 1 - the piggy bank is already empty with no values and has slots open
    addCoinTest.addCoin(penny);
    if (addCoinTest.getBalance() != 1) {
      System.out.println("Scenario 1: Problem detected. Your ElasticBank.addCoin() did not"
          + "return the expected output.");
      return false;
    }
    System.out.println("Size scenario 2: " + addCoinTest.getSize());
    // Scenario 2 - the piggy bank has to expand once
    addCoinTest.addCoin(quarter);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    if ((addCoinTest.getExpansions() != 1) | (addCoinTest.getSize() != 4)) {
      System.out.println("Scenario 2: Problem detected. Your ElasticBank.addCoin() did not"
          + "return the expected output.");
      return false;
    }
    System.out.println("Size scenario 3: " + addCoinTest.getSize());
    System.out.println("Expansions scenario 3: " + addCoinTest.getExpansions());
    // Scenario 3 - the piggy bank has to expand for a second time
    addCoinTest.addCoin(quarter);
    addCoinTest.addCoin(penny);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(dime);
    addCoinTest.addCoin(nickel);
    System.out.println("Size right before 2: " + addCoinTest.getSize());
    if ((addCoinTest.getExpansions() != 0) | (addCoinTest.getSize() != 17)) {
      System.out.println("Scenario 3: Problem detected. Your ElasticBank.addCoin() did not"
          + "return the expected output.");
      return false;
    }
    System.out.println("Size scenario 4: " + addCoinTest.getSize());
    // Scenario 4 - the piggy bank has to overflow
    addCoinTest.addCoin(quarter);
    addCoinTest.addCoin(penny);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(quarter);
    addCoinTest.addCoin(penny);
    addCoinTest.addCoin(nickel);
    addCoinTest.addCoin(quarter);
    System.out.println(addCoinTest.getCoins());
    if ((addCoinTest.getBalance() != 25) | (addCoinTest.getExpansions() != 0)) {
      System.out.println("Scenario 4: Problem detected. Your ElasticBank.addCoin() did not"
          + "return the expected output.");
      return false;
    }
    return true;
  }



  public static void main(String[] args) {
    System.out.println("testCoinInstantiableClass() Result: " + testCoinInstantiableClass());
    System.out.println("testGetCoins() Result: " + testGetCoins());
    System.out.println("testBalanceAccessors() Result: " + testBalanceAccessors());
    System.out.println("testRemoveCoin() Result: " + testRemoveCoin());
    System.out.println("testEmpty() Result: " + testEmpty());
    System.out.println("testAddCoin() Result: " + testAddCoin());
  }
}
