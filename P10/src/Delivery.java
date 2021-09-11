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
public class Delivery implements Comparable<Delivery>{
  private int studentId;
  private String robotName;
  private int distance;

  public Delivery(Student customer, FoodRobot starship) {
    distance = Math.abs(starship.getXPosition() - customer.getXPosition())
        + Math.abs(starship.getYPosition() - customer.getYPosition());
    studentId = customer.getId();
    robotName = starship.getName();
  }

  @Override
  public int compareTo(Delivery deliveryTwo) {
    if(distance < deliveryTwo.distance)
      return -1;
    //reaches here if greater distance or equal distance
    //give priority to lower student ID
    if(distance == deliveryTwo.distance && studentId < deliveryTwo.studentId)
      return -1;
    //greater distance or equal distance and two robots for 1 student
    if(distance == deliveryTwo.distance && (robotName.compareTo(deliveryTwo.robotName) < 0))
      return -1;
    return 1;
  }
  
  @Override
  public boolean equals(Object objectTwo) {
    
    if(objectTwo instanceof Delivery) {
      if(studentId == ((Delivery)objectTwo).studentId) {
        return true;
      }
      if(robotName.equals(((Delivery)objectTwo).robotName)) {
        return true;
      }
      return false;
    }
    
    if(objectTwo instanceof Student) {
      if(studentId == ((Student)objectTwo).getId()) {
        return true;
      }
      return false;
    }
    
    if(objectTwo instanceof FoodRobot) {
      if(robotName.equals(((FoodRobot)objectTwo).getName())) {
        return true;
      }
      return false;
    }
    return false;    
  }
  
  @Override
  public String toString() {
   return "The distance between " + studentId + " and " + robotName +
   " is " + distance;
  }
}
