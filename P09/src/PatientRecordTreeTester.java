//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The Patient Record Tree is a binary search tree made up of PatientRecord
// nodes. The program can iterate through the tree and add patients based
// on birth date, lookup patients by birth date, and return
// a list of the patients from oldest to youngest. Patients with the same
// birthday cannot exist in the same system.
// Files: PatientRecordTree.java, PatientRecordTreeTester.java, PatientRecord.java,
// PatientRecordNode.java
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
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output.
   * 
   * (3) Try adding another patientRecord which is older that the one at the root,
   * 
   * (4) Try adding a third patient Record which is younger than the one at the root,
   * 
   * (5) Try adding at least two further patient records such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an ascendant order from the oldest patient to the
   * youngest one.
   * 
   * (6) Try adding a patient whose date of birth was used as a key for a patient record already
   * stored in the tree. Make sure that the addPatientRecord() method call returned false, and that
   * the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    // test 1
    PatientRecordTree tree = new PatientRecordTree();
    if (tree.size() != 0)
      return false;
    if (!tree.isEmpty())
      return false;
    if (!tree.toString().contentEquals(""))
      return false;

    // test 2
    tree = new PatientRecordTree();
    PatientRecord a = new PatientRecord("a", "10/6/1975");
    if (!tree.addPatientRecord(a))
      return false;
    if (tree.isEmpty())
      return false;
    if (tree.size() != 1)
      return false;
    if (!tree.toString().equals("a(10/6/1975)\n"))
      return false;

    // test 3
    PatientRecord b = new PatientRecord("b", "9/2/1945");
    if (!tree.addPatientRecord(b))
      return false;
    if (tree.isEmpty())
      return false;
    if (tree.size() != 2)
      return false;
    if (!tree.toString().equals("b(9/2/1945)\na(10/6/1975)\n"))
      return false;
    // test 4
    PatientRecord c = new PatientRecord("c", "4/7/1999");
    if (!tree.addPatientRecord(c))
      return false;
    if (tree.isEmpty())
      return false;
    if (tree.size() != 3)
      return false;
    if (!tree.toString().equals("b(9/2/1945)\na(10/6/1975)\nc(4/7/1999)\n"))
      return false;

    // test 5
    PatientRecord d = new PatientRecord("d", "4/7/1993");
    if (!tree.addPatientRecord(d))
      return false;
    if (tree.isEmpty())
      return false;
    if (tree.size() != 4)
      return false;
    if (!tree.toString().equals("b(9/2/1945)\na(10/6/1975)\nd(4/7/1993)\nc(4/7/1999)\n"))
      return false;

    PatientRecord e = new PatientRecord("e", "4/7/1961");
    if (!tree.addPatientRecord(e))
      return false;
    if (tree.isEmpty())
      return false;
    if (tree.size() != 5)
      return false;
    if (!tree.toString()
        .equals("b(9/2/1945)\ne(4/7/1961)\na(10/6/1975)\nd" + "(4/7/1993)\nc(4/7/1999)\n"))
      return false;

    // test 6
    PatientRecord f = new PatientRecord("f", "4/7/1961");
    if (tree.addPatientRecord(f)) {
      return false;
    }
    if (tree.isEmpty())
      return false;
    if (tree.size() != 5)
      return false;
    if (!tree.toString()
        .equals("b(9/2/1945)\ne(4/7/1961)\na(10/6/1975)\nd" + "(4/7/1993)\nc(4/7/1999)\n"))
      return false;
    return true;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios.
   * 
   * (1) Create a new PatientRecordTree. Then, check that calling the lookup() method with any valid
   * date must throw a NoSuchElementException.
   * 
   * (2) Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes.
   * Then, try to call lookup() method to search for the patient record at the root of the tree,
   * then a patient records at the right and left subtrees at different levels. Make sure that the
   * lookup() method returns the expected output for every method call.
   * 
   * (3) Consider calling .lookup() method on a non-empty PatientRecordTree with a date of birth not
   * stored in the tree, and ensure that the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    // test 1
    PatientRecordTree tree = new PatientRecordTree();
    try {
      tree.lookup("3/4/1955");
      return false;
    } catch (NoSuchElementException e) {
    }

    // test 2
    tree = new PatientRecordTree();
    PatientRecord a = new PatientRecord("a", "10/6/1975");
    PatientRecord b = new PatientRecord("b", "9/2/1945");
    PatientRecord c = new PatientRecord("c", "4/7/1999");
    PatientRecord d = new PatientRecord("d", "4/7/1993");
    PatientRecord e = new PatientRecord("e", "4/7/1961");
    tree.addPatientRecord(a);
    tree.addPatientRecord(b);
    tree.addPatientRecord(c);
    tree.addPatientRecord(d);
    tree.addPatientRecord(e);

    // root
    if (tree.lookup("10/6/1975").compareTo(a) != 0)
      return false;
    // left level 2
    if (tree.lookup("9/2/1945").compareTo(b) != 0)
      return false;
    // left level 3
    if (tree.lookup("4/7/1961").compareTo(e) != 0)
      return false;
    // right level 2
    if (tree.lookup("4/7/1999").compareTo(c) != 0)
      return false;
    // right level 3
    if (tree.lookup("4/7/1993").compareTo(d) != 0)
      return false;

    // test 3
    try {
      tree.lookup("3/4/1955");
      return false;
    } catch (NoSuchElementException e1) {
    }
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as,
   * 
   * (1) ensures that the height of an empty patient record tree is zero.
   * 
   * (2) ensures that the height of a tree which consists of only one node is 1.
   * 
   * (3) ensures that the height of a PatientRecordTree with the following structure for instance,
   * is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // test 1
    PatientRecordTree tree = new PatientRecordTree();
    if (tree.height() != 0)
      return false;

    // test 2
    PatientRecord a = new PatientRecord("a", "10/6/1975");
    tree.addPatientRecord(a);
    if (tree.height() != 1)
      return false;

    // test 3
    PatientRecord b = new PatientRecord("b", "9/2/1945");
    PatientRecord c = new PatientRecord("c", "4/7/1999");
    PatientRecord d = new PatientRecord("d", "4/7/1993");
    PatientRecord e = new PatientRecord("e", "4/7/1961");
    PatientRecord f = new PatientRecord("f", "4/7/2003");
    PatientRecord g = new PatientRecord("g", "4/7/2001");
    tree.addPatientRecord(b);
    tree.addPatientRecord(c);
    tree.addPatientRecord(d);
    tree.addPatientRecord(e);
    tree.addPatientRecord(f);
    tree.addPatientRecord(g);
    if (tree.height() != 4)
      return false;
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    // test 1 - empty tree
    PatientRecordTree tree = new PatientRecordTree();
    if (tree.getRecordOfYoungestPatient() != null)
      return false;

    // test 2 - 1 node
    tree = new PatientRecordTree();
    PatientRecord a = new PatientRecord("a", "10/6/1975");
    tree.addPatientRecord(a);
    if (tree.getRecordOfYoungestPatient().compareTo(a) != 0)
      return false;

    // test 3 - random tree
    tree = new PatientRecordTree();
    PatientRecord b = new PatientRecord("b", "9/2/1945");
    PatientRecord c = new PatientRecord("c", "4/7/1999");
    PatientRecord d = new PatientRecord("d", "4/7/1993");
    PatientRecord e = new PatientRecord("e", "4/7/1961");
    tree.addPatientRecord(b);
    tree.addPatientRecord(c);
    tree.addPatientRecord(d);
    tree.addPatientRecord(e);
    if (tree.getRecordOfYoungestPatient().compareTo(c) != 0)
      return false;
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    // test 1 - empty tree
    PatientRecordTree tree = new PatientRecordTree();
    if (tree.getRecordOfOldestPatient() != null)
      return false;

    // test 2 - 1 node
    tree = new PatientRecordTree();
    PatientRecord a = new PatientRecord("a", "10/6/1975");
    tree.addPatientRecord(a);
    if (tree.getRecordOfOldestPatient().compareTo(a) != 0)
      return false;

    // test 3 - random tree
    tree = new PatientRecordTree();
    PatientRecord b = new PatientRecord("b", "9/2/1945");
    PatientRecord c = new PatientRecord("c", "4/7/1999");
    PatientRecord d = new PatientRecord("d", "4/7/1993");
    PatientRecord e = new PatientRecord("e", "4/7/1961");
    tree.addPatientRecord(b);
    tree.addPatientRecord(c);
    tree.addPatientRecord(d);
    tree.addPatientRecord(e);
    if (tree.getRecordOfOldestPatient().compareTo(b) != 0)
      return false;
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(
        "testing addPatientRecord() and toString(): " + testAddPatientRecordToStringSize());
    System.out
        .println("testing addPatientRecord() and lookup(): " + testAddPatientRecordAndLookup());
    System.out.println("testing testHeight(): " + testHeight());
    System.out
        .println("testing getRecordOfYoungestPatient()): " + testGetRecordOfYoungestPatient());
    System.out.println("testing getRecordOfOldestPatient()): " + testGetRecordOfOldestPatient());
  }

}
