//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This program controls a Queue (line) at the Badger Coaster.
// Standard guests are placed at the back of the queue and VIP guests
// are put at the front.
// can also search for a specific string.
// Files: BoardingGroup.java, BGNode.java, RideQueue.java, ThemeParkApp.java, sample.txt
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

/**
 * 
 * @author Joseph O'Connell
 * 
 *         The BoardingGroup class is an instantiable class used to control characteristics of each
 *         boarding group in the queue
 *
 */
public class BoardingGroup {
  private String name;
  private int people;
  private boolean Vip;

  /**
   * The boardingGroup constructor creates the instance with the name of the group and the number of
   * people in the group. By default the group is not VIP.
   * 
   * @param name   the string name of the group
   * @param people the number of people in the group
   */
  public BoardingGroup(String name, int people) {
    Vip = false;
    this.people = people;
    this.name = name;
  }

  /**
   * The accessor method for people returns the number of people in the requested group
   * 
   * @return number of people in the group in int form
   */
  public int getPeople() {
    return this.people;
  }

  /**
   * the name accessor method gives the name of the group
   * 
   * @return name of the group in String form
   */
  public String getName() {
    return this.name;
  }

  /**
   * the VIP accessor method for VIP shows if the group is VIP or not
   * 
   * @return true if the group is VIP, false if not
   */
  public boolean getVip() {
    return Vip;
  }

  /**
   * the VIP mutator method changes the group to VIP status
   */
  public void setVip() {
    Vip = true;
  }
}
