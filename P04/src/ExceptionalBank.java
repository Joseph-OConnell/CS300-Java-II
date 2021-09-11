//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Much like P3, ExceptionalBank is an elastic bank to count coins, but Exceptional Bank accounts for possible exceptions.  
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class implements an expanded version of elastic bank application
 * 
 */
public class ExceptionalBank {
  private Coin[] coins; // array which stores all coins held in this elastic bank
  private int size; // size of this elastic bank
  private int expansionsLeft; // number of expansions left for this elastic bank
  private static Random rand = new Random(100); // random integers generator

  /**
   * Creates a new elastic bank object with a given initial capacity
   * 
   * @param initialCapacity initial capacity of this elastic bank
   * @throws IllegalArgumentException
   */
  public ExceptionalBank(int initialCapacity) throws IllegalArgumentException {
    // throw exception if illegal input
    if (initialCapacity < 1) {
      throw new IllegalArgumentException(
          "WARNING! The initial capacity of " + "a bank must be a non-zero positive integer.");
    }
    coins = new Coin[initialCapacity];
    this.expansionsLeft = 2;
  }

  /**
   * Creates a new elastic bank object with an initial capacity equal to 10
   */
  public ExceptionalBank() {
    this(10);
  }

  /**
   * Returns the capacity of this elastic bank
   * 
   * @return the capacity of this elastic bank
   */
  public int capacity() {
    return coins.length;
  }

  /**
   * Returns the expansions left for this elastic bank
   * 
   * @return the expansions left for this elastic bank
   */
  public int getExpansions() {
    return this.expansionsLeft;
  }

  /**
   * Returns the number of coins held in this elastic bank
   * 
   * @return the size of this elastic bank
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Returns the value in cents of coins held in this elastic bank
   * 
   * @return the balance of this elastic bank
   */
  public int getBalance() {
    int balance = 0;
    // add the value of each coin held in this bank to balance, then return it
    for (int i = 0; i < size; i++) {
      balance += coins[i].value();
    }
    return balance;
  }

  /**
   * Returns the number of coins with a specific coinName held in this bank. The coin name
   * comparison is case insensitive
   * 
   * @param coinName name of a coin
   * @return the count of coins having the provided coinName, held in this bank
   */
  public int getSpecificCoinCount(String coinName) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (coins[i].name().equalsIgnoreCase(coinName))
        count++;
    }
    return count;
  }

  /**
   * Returns a string representation of all the coins held in this elastic bank. Each coin is
   * represented by the pair "(name, value)", and the string representation should contain all of
   * these pairs in one space-separated line. For example: "(PENNY, 1) (QUARTER, 25) (PENNY, 1)
   * (DIME, 10) (NICKEL, 5)"
   * 
   * @return a String representation of the contents of the bank.
   */
  public String getCoins() {
    String contents = "";
    // traverse the coins oversize array and add each coin's string representation to the string to
    // be returned
    for (int i = 0; i < size; i++) {
      contents += "(" + coins[i].name() + ", " + coins[i].value() + ")";
      if (i < size - 1)
        contents += " ";
    }
    return contents;
  }



  /**
   * Returns a summary of this bank contents
   * 
   * @return an empty string if this bank is empty, and a string representation of the summary of
   *         this bank otherwise. The summary of the bank is a set of lines. Each line is formatted
   *         as follows "coin_name:coin_count"
   */
  public String getSummary() {
    String summary = "";
    Coin[] values = Coin.values();
    // traverse this bank contents and update its summary
    for (int i = 0; i < values.length; i++) {
      String name = values[i].name();
      int count = getSpecificCoinCount(name);
      if (count != 0) {
        summary += name + ":" + count + "\n";
      }
    }
    return summary.trim(); // remove whitespace (spaces, new lines etc.) from the beginning and end
                           // of summary and return the resulting string

  }

  /**
   * Removes and returns a coin at a random position from this elastic bank
   * 
   * @return the removed coin or null if this bank is empty
   * @throws NoSuchElementException
   */
  public Coin removeCoin() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException("WARNING! This bank is empty. Unable to remove a coin.");
    }
    int randPosition = rand.nextInt(size); // get a random position from 0 .. size-1
    Coin removedCoin = coins[randPosition]; // store the coin to be removed
    // The order of the coins within this bank (a piggy bank) is not important
    // So, move the coin at the end of the coins array to the random position
    // and set that last element to null.
    coins[randPosition] = coins[size - 1];
    coins[size - 1] = null;
    size--; // update size
    return removedCoin;
  }

  /**
   * Removes all the coins from this elastic bank
   */
  public void empty() {
    // set all the non-null references within the coins array to null
    for (int i = 0; i < size; i++) {
      coins[i] = null;
    }
    // set the size of this bank to 0
    size = 0;
  }

  /**
   * adds a Coin to the bank and adjusts the capacity of coins if necessary and possible
   * 
   * @param c coin to be added to this elastic bank
   * @throws IllegalArgumentException
   */
  public void addCoin(Coin c) throws IllegalArgumentException {
    if (c == null) {
      throw new IllegalArgumentException("WARNING! You cannot add a null reference to this bank.");
    }
    // check if this bank is full
    if (size == coins.length) {
      // check whether there are expansions left
      if (this.expansionsLeft > 0) {
        // expand the capacity of this elastic bank by 10
        coins = Arrays.copyOf(coins, coins.length + 10);
        this.expansionsLeft--;
      } else { // no expansions left
        // empty this elastic bank
        empty();
      }
    }
    // add c at the end of this bank
    coins[size] = c;
    size++;
  }

  /**
   * Adds a number of the same coin type with respect to a provided command line. 
   * The format of the command line is "coin_name:coins_count". 
   * Such command line refers to adding coins_count of coin_name to this bank.
   * @param command
   * @throws java.util.zip.DataFormatException
   */
  public void addCoins​(java.lang.String command) throws java.util.zip.DataFormatException, IllegalArgumentException {
    // throw exception if parameter is null
    if (command == null) {
      throw new IllegalArgumentException(
          "WARNING! The addCoins() method does not accept a null reference as input.");
    }
    String[] components = command.split(":");
    // throw exception if there is more than 2 components
    if (components.length != 2) {
      throw new DataFormatException("The format of the command line " + command + " is incorrect.");
    }
    // trim and clean up input
    String first = components[0].trim().toUpperCase();
    String second = components[1].trim();
    // throw exception if second one is not an integer
    try{
      Integer.parseInt(second);
    }
    catch(NumberFormatException d)
    {
      throw new DataFormatException("The format of the command line " + command + " is incorrect.)");
    }
    int count = Integer.parseInt(second);
    // deal with negative numbers
    if (count < 0) {
      throw new DataFormatException("The format of the command line " + command + " is incorrect.)");
    }
    // throw exception if the coin is not in the enum
    int index = 0;
    Coin[] coinNames = Coin.values();
    for (int i = 0; i < coinNames.length; i++) {
      if (first.equals(coinNames[i].toString())) {
        index = i;
        break;
      }
      if (i == coinNames.length - 1) {
        throw new NoSuchElementException(
            "The coin name provided in the command line " + command + " is invalid.");
      }
    }
    // now add the coin to the bank
    Coin c = coinNames[index];

    for (int i = 0; i < count;i++) {
      // add a coin to the bank if there is room
      if (this.coins.length > this.size) {
        this.coins[this.size] = c;
        this.size++;
        continue;
      }
      // expand the bank if you can
      Coin[] tempCoin = new Coin[this.size + 10];
      if (this.expansionsLeft > 0) {
        for (int j = 0; j < size; j++) {
          tempCoin[j] = this.coins[j];
        }
        this.coins = tempCoin;
        expansionsLeft--;
        // now add the coin
        this.coins[this.size] = c;
        this.size++;
        continue;
      }
      // piggy bank bursts!
      this.empty();
      this.coins[this.size] = c;
      this.size++;
      continue;
    }
  }

  /**
   * Load a list of coins from a file object which refers to a data file 
   * written in a specific format (a set of lines each formatted as follows "coin_name:coin_count"). 
   * Lines formatted correctly will be added as new coins to this elastic bank. 
   * Lines formatted incorrectly must be skipped (go to the next line). 
   * @param file
   * @throws java.io.FileNotFoundException
   */
  public void loadCoins​(java.io.File file) throws java.io.FileNotFoundException{
    if(file == null) {
      throw new NullPointerException("Error file is null");
    }
    try {
      Scanner input = new Scanner(file);
    }
    catch(FileNotFoundException d)
    {
      throw new FileNotFoundException("Error file not found");
    }
    // try to add coins from file
    Scanner input = new Scanner(file);
    while(input.hasNextLine()) {
      try {
        addCoins​(input.nextLine());
      }
      catch(NoSuchElementException | DataFormatException message)
      {
        System.out.println("WARNING! Skipping line. " + message);
      }
    }
    input.close();
  }
  
  /**
   * Save the summary of this bank to the provided file in a specific format for each line: coin_name:coin_count.
   * @param file
   * @throws FileNotFoundException 
   */
  public void saveBankSummary​(java.io.File file) throws NullPointerException, FileNotFoundException{
    if(file == null) {
      throw new NullPointerException("Error file is null");
    }    
    PrintWriter writer = new PrintWriter(file);
    writer.println(this.getSummary());
    writer.close();
  }
}


