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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The ShallowFileIterator will iterate through all the contents of one directory.
 * 
 * @author Joseph O'Connell
 *
 */
public class ShallowFileIterator implements Iterator<File> {
  // variables
  private File[] folderContents;
  private int nextIndex = 0;

  /**
   * The constructor for the shallowfileiterator class. The constructor defines the file array
   * representing the contents of the directory
   * 
   * @param file the reference to the directory being iterated through
   * @throws FileNotFoundException if the parameter is not a directory or null
   */
  public ShallowFileIterator(File file) throws FileNotFoundException {
    if (file == null || !file.isDirectory()) {
      throw new FileNotFoundException("Directory does not exist");
    }
    folderContents = file.listFiles(); // this can return a null
    Arrays.sort(folderContents);
  }

  /**
   * The has next method returns true when there is another file to iterate through in the directory.
   * @return true when there is another file in the directory or otherwise false
   */
  @Override
  public boolean hasNext() {
    if (nextIndex >= folderContents.length)
      return false;
    return true;
  }

  /**
   * The next method returns the next file instance in the sorted array of folder contents.
   * @throws NoSuchElementException when there are no more files in the folder
   * @return the next file instance in the directory
   */
  @Override
  public File next() throws NoSuchElementException {
    if (this.hasNext()) {
      File tempFile = folderContents[nextIndex];
      nextIndex++;
      return tempFile;
    } else {
      throw new NoSuchElementException("no more files in folder");
    }
  }

}
