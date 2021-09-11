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
public class FoodRobot {
private int x;
private int y;
private String name = null;

public FoodRobot(int x, int y, String name) {
 this.x = x;
 this.y = y;
 this.name = name;
}

public int getXPosition() {
  return x;
}

public int getYPosition() {
  return y;
}

public String getName() {
  return name;
}

@Override
public String toString() {
  return name + "(" + x + ", " + y + ")";
}

}
