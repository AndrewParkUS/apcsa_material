import java.io.*;
import java.util.*;


public class MyLinkedList{

  private Node head;

  public MyLinkedList() {
    head = null;
  }


  /* Add a new node which data value to the front of the list */
  public void add(String value) {
    Node tempNode = new Node(value);
    tempNode.next = head;
    head = tempNode;

  }

  /* Returns the value in the node at location index. */
  public String get(int index) {
    String value = "";
  
    // Create a reference to head. It will help loop through the list
    Node walker = head;
    // Counter to track a node position
    int counter = 0;
    
    return value;
  }

  /* Return the list as a string */
  public String toString() {
    String stringified = "";
    // Create a reference to head. It will help loop through the list
    Node walker = head;
    
    return stringified;
  }

  /* Returns the number of elements in the list */
  public int size() {
    int size = 0;
    Node temp = head;

    while (temp != null) {
      temp = temp.next;
      size++;
    }

    return size;
  }


  /*Adds a new node which contains value at index */
  public void add(int index, String value) {

  }


  /* Returns the index of the first node in the list that contains value. */
  public int indexOf(String value) {
    int index = 0;
    // insert
    return index;
  }


  /* Remove node al location index */

  public void remove(int index) {
  }
}