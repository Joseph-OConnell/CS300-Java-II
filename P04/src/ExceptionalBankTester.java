//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Class to test the functionality of ExceptionalBank
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

public class ExceptionalBankTester {

  /**
   * This method checks whether the ExceptionalBank.addCoin() method throws an 
   * IllegalArgumentException with an appropriate error message, when it is passed a null reference.
   * @return true when the exception is output is correct
   */
  public static boolean testAddCoin() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoin(null);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }
  
  /**
   * This method checks whether ExceptionalBank.addCoins() 
   * method throws an IllegalArgumentException with an appropriate error message 
   * when it is passed a null reference as input argument.
   * @return true when the exception is output is correct
   */
  public static boolean  testAddCoinsIllegalArgument() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoins​(null);
    } catch (IllegalArgumentException | DataFormatException e) {
      return true;
    }
    return false;
  
  }
  
  /**
   * This method checks whether ExceptionalBank.addCoins() method throws 
   * a DataFormatException with an appropriate error message 
   * when it is passed an incorrectly formatted string object, 
   * for instance "quarter: five", or ": 6", or "DIME:-5"
   * @return true when the exception is output is correct
   */
  static boolean  testAddCoinsInvalidDataFormat() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoins​("penny:five");
    } catch (IllegalArgumentException | DataFormatException e) {
      return true;
    }
    return false;
  }
  
  /**
   * This method checks whether ExceptionalBank.addCoins() method throws a 
   * NoSuchElementException with an appropriate error message when 
   * it is passed a String object with a correct format (meaning "string:positive_number"), 
   * but with a coin name not defined in the enum Coin's constants.
   * @return true when the exception is output is correct
   */
  static boolean  testAddCoinsNoSuchElement() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoins​("TunnelBob:12");
    } catch (NoSuchElementException | IllegalArgumentException | DataFormatException e) {
      return true;
    }
    return false;
  }
  
  /**
   * This method checks whether the ExceptionalBank.addCoins() 
   * works appropriately when it is passed a String with a valid format.
   * @return true when the exception is output is correct
   */
  static boolean  testAddCoinsValidFormat() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoins​("quarter:12");
    } catch (NoSuchElementException | IllegalArgumentException | DataFormatException e) {
      return false;
    }
    return true;
  }
  
  /**
   * This method checks whether the ExceptionalBank constructor throws an IllegalArgumentException
   * with appropriate error message, when it is passed a zero or a negative capacity. This test must
   * fail if another kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(-10);
      System.out
          .println("Problem detected. The constructor call of the ExceptionalBank class did not "
              + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the ExceptionalBank class when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionBank class with a negative argument. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true; // test passed
  }
  
  /**
   * This method checks whether the ExceptionalBank 
   * constructor creates without errors an empty exceptional 
   * bank with capacity 20 when it is passed 20 as input parameter.
   * @return true when the exception is output is correct
   */
  static boolean  testGoodExceptionalBankConstructor()  {
    ExceptionalBank bank = new ExceptionalBank(20);
   if(bank.capacity() == 20) {
    return true;
   }
   else {
     return false;
   }
  }

  /**
   * This method checks whether ExceptionalBank.loadCoins() 
   * method loads appropriately without throwing any exception 
   * when it is passed a found file.
   * @return true when the exception is output is correct
   */
  static boolean  testLoadCoinsFileFound() {
    File file = new File("sample1.txt");
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.loadCoins​(file);
    } catch (FileNotFoundException e) {
      return false;
    }
    return true;
  }
  
  /**
   * This method checks whether ExceptionalBank.loadCoins() 
   * method throws a FileNotFoundException when it is passed a non found file.
   * @return true when the exception is output is correct
   */
  static boolean  testLoadCoinsFileNotFound() {
    File file = new File("tunnelbob.txt");
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.loadCoins​(file);
    } catch (FileNotFoundException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether ExceptionalBank.loadCoins() 
   * method throws a NullPointerException when it is passed a null reference.
   * @return true when the exception is output is correct
   */
  static boolean  testLoadCoinsNullReference() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.loadCoins​(null);
    } catch (NullPointerException | FileNotFoundException e) {
      return true;
    }
    return false;
  }
  
  /**
   * This method checks whether the ExceptionalBank.removeCoin() 
   * method throws a NoSuchElementException with an appropriate 
   * error message, when it is called on an empty bank.
   * @return true when the exception is output is correct
   */
  static boolean  testRemoveCoinEmptyBank() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.removeCoin();
    } catch (NoSuchElementException e) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("testAddCoin Result: " + testAddCoin());
    System.out.println("testAddCoinsIllegalArgument Result: " + testAddCoinsIllegalArgument());
    System.out.println("testAddCoinsInvalidDataFormat Result: " + testAddCoinsInvalidDataFormat());
    System.out.println("testAddCoinsNoSuchElement Result: " + testAddCoinsNoSuchElement());
    System.out.println("testAddCoinsValidFormat Result: " + testAddCoinsValidFormat());
    System.out.println("testExceptionalBankConstructor Result: " + testExceptionalBankConstructor());
    System.out.println("testGoodExceptionalBankConstructor Result: " + testGoodExceptionalBankConstructor());
    System.out.println("testLoadCoinsFileFound Result: " + testLoadCoinsFileFound());
    System.out.println("testLoadCoinsFileNotFound Result: " + testLoadCoinsFileNotFound());
    System.out.println("testLoadCoinsNullReference Result: " + testLoadCoinsNullReference());
    System.out.println("testRemoveCoinEmptyBank Result: " + testRemoveCoinEmptyBank());
  }
}
