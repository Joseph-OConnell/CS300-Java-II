//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: An elastic bank to hold coins with the power to expand twice before bursting
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
import java.util.Random;

public class ElasticBank {
  private Coin[] coins;
  private int size;
  private int expansionsLeft;
  private static Random rand = new Random(24);

/**
 * default constructor to initialize the Elastic Bank
 */
  public ElasticBank() {
    this.size = 0;   
    this.expansionsLeft = 2;
    coins = new Coin[10];

  }

  /**
   * constructor to initialize the Elastic Bank with the argument initial capacity
   * 
   * @param initialCapacity
   */
  public ElasticBank(int initialCapacity) {
    this.size = 0;
    this.expansionsLeft = 2;
    this.coins = new Coin[initialCapacity];
  }

  /**
   * Determines the remaining capacity in the bank
   * 
   * @return remaining slots for items in the bank
   */
  public int capacity() {
    return (this.coins.length - this.size);
  }

  /**
   * Determines the number of expansions left in the bank
   * @return int number of expansions
   */
  public int getExpansions() {
    return this.expansionsLeft;
  }

  /**
   * determines the number of coins in the bank
   * @return int number of coins in bank
   */
  public int getSize() {
    return this.size;
  }

  /**
   * determines the current balance of the bank
   * @return int total of the value of money in the bank
   */
  public int getBalance() {
    int total = 0;
    for (int i = 0; i < this.size; i++) {
      total += this.coins[i].getValue();
    }
    return total;
  }

  /**
   * shows the user what coins are in the bank
   * @return  string list of the coins and values
   */
  public String getCoins() {
    String printOut = "";
    for (int i = 0; i < this.size - 1; i++) {
      printOut =
          printOut + "(" + (this.coins[i].getName()) + ", " + (this.coins[i].getValue()) + ") ";
    }
    printOut = printOut + "(" + (this.coins[this.size - 1].getName()) + ", "
        + (this.coins[this.size - 1].getValue()) + ")";
    return printOut;
  }

  // mutators are below
  /**
   * removes a coin at random from the bank
   * @return null if there is no coin to remove.  returns a new coin object with the properties of the removed coin.  
   */
  public Coin removeCoin() {
    if (this.size == 0 || this.coins == null) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
      return null;
    }
    // remove a random coin from the array
    // first find a spot with a coin
    int ind = 0;
    ind = ElasticBank.rand.nextInt(this.size);
    // find what the coin is
    String coin_name = this.coins[ind].getName();
    Coin newCoin = new Coin(this.coins[ind].getName(), this.coins[ind].getValue());
    // replace coin with last coin in the array and reduce the size
    this.coins[ind] = this.coins[size - 1];
    this.coins[this.size - 1] = null;
    this.size--;
    System.out.println("Removed a " + coin_name + ".");

    return newCoin;
  }

  /**
   * empties the piggy bank of all coins and prints out how many cents were removed.  
   */
  public void empty() {
    if (this.size == 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
    }
    // empty the piggy bank now
    int total = 0; // sum of all removed cents
    for (int i = 0; i < this.size; i++) {
      total = total + this.coins[i].getValue();
      this.coins[i] = null;
    }
    System.out.println("All done. " + total + " cents removed.");
    this.size = 0;
  }

  /**
   * a method to add a coin to the bank.  If the bank is full it will expand.  If there are no expansions remaining, the bank will burst.  
   * @param c a Coin object
   */
  public void addCoin(Coin c) {
    // add a coin to the bank if there is room
    if (this.coins.length > this.size) {
      this.coins[this.size] = c;
      this.size++;
      return;
    }
    // expand the bank if you can
    Coin[] tempCoin = new Coin[this.size + 10];
    if (this.expansionsLeft > 0) {
      for (int i = 0; i < size; i++) {
        tempCoin[i] = this.coins[i];
      }
      this.coins = tempCoin;
      expansionsLeft--;
      // now add the coin
      this.coins[this.size] = c;
      this.size++;
      return;
    }
    // piggy bank bursts!
    this.empty();
    this.coins[this.size] = c;
    this.size++;
    return;
  }
}
