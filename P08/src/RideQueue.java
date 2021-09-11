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
import java.util.NoSuchElementException;

/**
 * The RideQueue class implements QueueADT for the Boarding Group type. This class controls
 * different aspects of the rider Queue, including capacity, number of people and groups in line,
 * and who is at the front and back of the line.
 * 
 * @author Joseph O'Connell
 *
 */
public class RideQueue implements QueueADT<BoardingGroup> {
  private BGNode front;
  private BGNode back;
  private int capacity;
  private int numOfPeople;
  private int numOfGroups;

  /**
   * The RideQueue constructor creates a Queue for the badger coaster with the given capacity.
   * 
   * @param capacity the max number of people allowed in line
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
  }

  @Override
  /**
   * the isempty method determines if the queue is empty
   * 
   * @returns true if the queue is empty and false if not
   */
  public boolean isEmpty() {
    if (numOfPeople == 0)
      return true;
    return false;
  }

  @Override
  /**
   * The size method gives the number of nodes in the queue.
   * 
   * @returns int value of the number of groups in line.
   */
  public int size() {
    return numOfGroups;
  }

  @Override
  /**
   * The enqueue method adds the requested group to the queue if there is enough space. Otherwise,
   * it throws an exception. If the group is VIP they are moved to the front of the line.
   * 
   * @param newGroup the group that wants to be added to the queue.
   * @throws IllegalStateException if there is not enough space in the queue for the group.
   */
  public void enqueue(BoardingGroup newGroup) throws IllegalStateException {
    // deal with exception
    if (numOfPeople + newGroup.getPeople() > capacity) {
      throw new IllegalStateException("The new group cannot fit in the line");
    }
    // add new group of people to queue
    // if the queue is empty
    if (numOfGroups == 0) {
      front = new BGNode(newGroup);
      back = front;
      numOfGroups++;
      numOfPeople += newGroup.getPeople();
      return;
    }
    if (newGroup.getVip()) {
      BGNode tempBGNode = new BGNode(newGroup); // temp mode for readjusting queue
      tempBGNode.setNext(front);
      front = tempBGNode;
      numOfGroups++;
      numOfPeople += newGroup.getPeople();
      return;
    }
    // reaches here if not VIP and at least 1 other group in queue
    BGNode tempBGNode = new BGNode(newGroup); // just a temp node to move pointer
    back.setNext(tempBGNode);
    back = tempBGNode;
    numOfGroups++;
    numOfPeople += newGroup.getPeople();
    return;
  }

  @Override
  /**
   * the clear method removes all people from the queue.
   */
  public void clear() {
    front = null;
    back = null;
    numOfPeople = 0;
    numOfGroups = 0;
  }

  @Override
  /**
   * The peek method returns the BoardingGroup that is at the front of the queue.
   * 
   * @returns BoardingGroup the group that is at the front of the queue
   * @throws NoSuchElementException if the Queue is empty
   */
  public BoardingGroup peek() throws NoSuchElementException {
    if (numOfPeople == 0 || numOfGroups == 0) {
      throw new NoSuchElementException("Queue is empty");
    }
    return front.getGroup();
  }

  @Override
  /**
   * The dequeue method removes one group from the front of the queue and readjusts the front
   * pointer.
   * 
   * @returns BoardingGroup the group that was removed from the queue.
   * @throws NoSuchElementException if the Queue is empty
   */
  public BoardingGroup dequeue() throws NoSuchElementException {
    // deal with exception if empty
    if (numOfPeople == 0 || numOfGroups == 0) {
      throw new NoSuchElementException("Queue is empty");
    }
    // assume not empty
    BoardingGroup nextUp = front.getGroup();
    front = front.getNext();
    numOfGroups--;
    numOfPeople -= nextUp.getPeople();
    return nextUp;
  }


  /**
   * The toString method shows the Queue in string form.
   * 
   * @returns a string representation of this RideQueue.
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getName();
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }
}
