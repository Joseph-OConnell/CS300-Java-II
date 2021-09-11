//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This program iterates through file directories and returns file references to sub directories and their files.  The filteredIterator
// can also search for a specific string.  
// Files: ShallowFileIterator.java, DeepFileIterator.java, FilteredFileIterator.java, P07Tester.java
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

/**
 * The P07 tester tests the functionality of the methods in this project
 * @author Joseph O'Connell
 *
 */
public class P07Tester {
  
  /**
   * This method tests the shallowFileIterator for correct output and returns 
   * true if it succeeds
   * @param file the reference to the directory being iterated through
   * @return true if the call returns the correct output. false otherwise
   */
  public static boolean testShallowFileIterator(File file) {
    //create a new ShallowFileIterator
    ShallowFileIterator testShallow = null;
    try {
      testShallow = new ShallowFileIterator(file);  
    }
    catch(FileNotFoundException e) {
      System.out.println(e);
      return false;
    }
    //iterate through the directory till it runs out
    String fileList = "";
    try {
      while(true) {
        fileList = fileList + testShallow.next().getName() + ", ";
      }
    }
    catch(NoSuchElementException e) {
    }
    String expectedResults = "assignments, exam preparation, lecture notes, "
        + "reading notes, todo.txt, ";
    if(fileList.equals(expectedResults))
      return true;
    return false;
  }
  
  /**
   * This method tests the DeepFileIterator for correct output and returns 
   * true if it succeeds
   * @param folder the reference to the directory being iterated through
   * @return true if the call returns the correct output. false otherwise
   */
  public static boolean testDeepFileIterator(File folder) {
    folder = new File(folder.getPath() + File.separator + "assignments");
  //create a new DeepFileIterator
    DeepFileIterator testDeep = null;
    try {
      testDeep = new DeepFileIterator(folder);  
    }
    catch(FileNotFoundException e) {
      System.out.println(e);
      return false;
    }
    //iterate through the directory till it runs out
    String fileList = "";
    try {
      while(true) {
        fileList = fileList + testDeep.next().getName() + ", ";
      }
    }
    catch(NoSuchElementException e) {
    }
    String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
        + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
        + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
    if(fileList.equals(expectedResults))
      return true;
    System.out.println(fileList);
    return false;
  }
  
  /**
   * This method tests the FilteredFileIterator for correct output and returns 
   * true if it succeeds
   * @param file the reference to the directory being iterated through
   * @return true if the call returns the correct output. false otherwise
   */
  public static boolean testFilteredFileIterator(File file) {
    //create a new DeepFileIterator
      FilteredFileIterator testFilter = null;
      try {
        testFilter = new FilteredFileIterator(file, ".java");  
      }
      catch(FileNotFoundException e) {
        System.out.println(e);
        return false;
      }
      //iterate through the directory till it runs out
      String fileList = "";
      try {
        while(true) {
          fileList = fileList + testFilter.next().getName() + ", ";
        }
      }
      catch(NoSuchElementException e) {
      }
      String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
          + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
          + "AlphabetTrain.java, codeSamples.java, ";
      if(fileList.equals(expectedResults))
        return true;
      System.out.println(fileList);
      return false;
    }

  /**
   * The main method for the testing file simply calls and prints the test methods
   * defined in this file
   * @param args command line input not used
   */
  public static void main(String[] args) {
    File folder = new File("filesystem");
    System.out.println("Testing ShallowFileIterator: " + testShallowFileIterator(folder));
    System.out.println("Testing DeepFileIterator: " + testDeepFileIterator(folder));
    System.out.println("Testing FilterFileIterator: " + testFilteredFileIterator(folder));
  }

}
