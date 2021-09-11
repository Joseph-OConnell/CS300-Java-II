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
 * The DeepFileIterator class will iterate through all the nested files and
 * directories of a given directory.
 * @author Joseph O'Connell
 *
 */
public class DeepFileIterator implements Iterator<File> {
  // variables
  private File[] folderContents;
  private int nextIndex = 0;
  private DeepFileIterator contentsIterator = null;

  /**
   * The constructor for the deepfileiterator class. The constructor defines the file array
   * representing the contents of the current directory.
   * @param file the reference to the directory being iterated through
   * @throws FileNotFoundException if the parameter is not a directory or null
   */
  public DeepFileIterator(File file) throws FileNotFoundException {
    if (file == null || !file.isDirectory()) {
      throw new FileNotFoundException("Directory does not exist");
    }
    folderContents = file.listFiles(); // this can return a null
    Arrays.sort(folderContents);
  }

  /**
   * The has next method for deep iterator determines if therer is another file instance
   * in the current directory, OR if the last file is a directory with more file instances inside.   
   * @return true or false depending if there is another matching file.
   */
  @Override
  public boolean hasNext() {
    if (nextIndex < folderContents.length || contentsIterator != null && contentsIterator.hasNext())
      return true;
    return false;
  }

  /**
   * the next method for the deep iterator class returns the next instance of a file in the current
   * directory.  If that instance is also a directory, it will return the directory and
   * then iterate through that directory.  
   * @throws NoSuchElementException when there is no more file instances in the directory
   * @return the next instance of a file or directory
   */
  @Override
  public File next() throws NoSuchElementException {
    if (contentsIterator != null && contentsIterator.hasNext())
      return contentsIterator.next();
    else {
      contentsIterator = null;
    }
    if (this.hasNext() && folderContents[nextIndex].isDirectory()) {
      try {
        contentsIterator = new DeepFileIterator(folderContents[nextIndex]);
      } catch (FileNotFoundException e) {
      }
      File tempFile = folderContents[nextIndex];
      nextIndex++;
      return tempFile;
    }
    if (this.hasNext()) {
      File tempFile = folderContents[nextIndex];
      nextIndex++;
      return tempFile;
    } else {
      throw new NoSuchElementException("no more files in folder");
    }
  }
}
