//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This program iterates through file directories and returns file references to sub
//////////////// directories and their files. The filteredIterator
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The FilteredFileIterator functions the exact same as the deepfileiterator
 * except that you can choose to only return file references that include a certain
 * search query.
 * @author Joseph O'Connell
 *
 */
public class FilteredFileIterator implements Iterator<File> {
  // variables
  private DeepFileIterator fileIterator = null;
  private String searchPattern = "";
  private File nextMatchingFile;

  /**
   * The constructor for the filteredfileiterator class.  It initializes the searchPattern and
   * nextMatchingFile variables and defines fileIterator as a new deepfileiterator.
   * @param file the reference to the directory being iterated through
   * @param search a string that represents the term being searched in the directory.  
   * @throws FileNotFoundException if the parameter is not a directory or null
   */
  public FilteredFileIterator(File file, String search) throws FileNotFoundException {
    // defining variables
    if (search == null) {
      return;
    }
    searchPattern = search;
    if (file == null || !file.isDirectory()) {
      throw new FileNotFoundException("Directory does not exist");
    }
    fileIterator = new DeepFileIterator(file);
    File tempFile = findNext();
    if (tempFile != null) {
      nextMatchingFile = tempFile;
    }
  }

  /**
   * the has next method will return true if the nextMatchingFile is not null
   * otherwise it will return false
   * @return true or false depending if there is another matching file.
   */
  @Override
  public boolean hasNext() {
    if (nextMatchingFile != null)
      return true;
    return false;
  }
  
  /**
   * The find next is a private helper method to find the next instance of a file with
   * the correct search terms.  If there are no more files it will return null.  
   * @return the next instance of a file that matches the search terms or null
   */
  private File findNext() {
    File tempFile;
    while (fileIterator.hasNext()) {
      tempFile = fileIterator.next();
      if (tempFile.getName().contains(searchPattern)) {
        return tempFile;
      }
    }
    return null;
  }

  /**
   * the next method will return the next instance of a file or directory that contains the
   * search terms.  
   * @throws NoSuchElementException when there is no more file instances in the directory
   * @return The next instance of a file that matches the search terms
   */
  @Override
  public File next() throws NoSuchElementException {
    File tempFile;
    if (nextMatchingFile == null) {
      tempFile = findNext();
    } else {
      tempFile = nextMatchingFile;
    }
    if (tempFile != null) {
      nextMatchingFile = null;
      return tempFile;
    } else {
      throw new NoSuchElementException("no more files in folder");
    }
  }
}
