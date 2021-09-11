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

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  public DeliveryQueue() {
    size = 0;
    heap = new Delivery[INITIAL_CAPACITY];
  }

  //done
  public void offerDelivery(Delivery delivery) {
    if(heap.length == size) {
      Delivery[] newHeap = new Delivery[2*size];
      for(int i = 0; i < heap.length; i++) {
        newHeap[i] = heap[i];
      }
      heap = newHeap;
    }
    //now add delivery to queue
    heap[size] = delivery;
    percolateUp(size);
    size++;
  }

  //done
  public Delivery pollBestDelivery() {
    if(isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }    
    Delivery temp = heap[0];
//    int different = 0;
//    //special case if all elements are the same or there's only 1 element
//    for(int i = 0; i < size; i++) {
//      if(temp.equals(heap[i])) {
//      }
//      else {
//        different++;
//      }
//    }
//    //if different is zero here, all elements are same or only 1 element
//    if(different == 0) {
//      
//    }
    heap[0] = null;
    size --;
    for(int i = 1; i < size; i++) {
      if(temp.equals(heap[i])) {
        heap[i] = null;
        size--;
      }
    }
    heapify();
    return temp;
  }

  //done
  public Delivery peek() throws NoSuchElementException{
    if(isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    heapify();
    return heap[0];
  }
  
  //done
  public int getSize() {
    return size;
  }
  
  //done
  public boolean isEmpty() {
    if(size == 0)
      return true;
    return false;
  }
  
  //done
  private void percolateUp(int index) {
    while(index > 0) {
      int parent = (int) Math.floor((index - 1)/2);
      if(heap[index].compareTo(heap[parent]) > 0) {
        return;        
      }
      else {
        Delivery temp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = temp;
        percolateUp(parent);
      }
    }
  }
  
  private void percolateDown(int index) {
    Delivery temp = heap[index];
    heap[index] = heap[2*index + 1];
    heap[2*index + 1] = temp;
  }
  
  private void heapify() {
    
  }
  
  @Override
  public String toString() {
   String string = "This DeliveryQueue contains " + size + " elements";
   if (size == 0) {
   return string;
   }
   string += ": [ ";
   for(int i=0; i<size; i++)
   string += "\n" + heap[i].toString();
   string += " ]\n";
   return string;
  }
  

}
