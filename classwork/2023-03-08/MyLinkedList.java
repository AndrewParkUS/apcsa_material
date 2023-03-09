import java.io.*;
import java.util.*;

public class MyLinkedList {

  private Node head;

  public MyLinkedList() {
    head = null;
  }

  /* Add a new node which data value to the front of the list */
  public void add (String value) {
    Node temp = new Node(value);
    temp.setNext(head);
    head = temp;
  }

  /* Returns the value in the node at location index. */
  public String get(int index) {
    // Create a reference to head. It will help loop through the list
    Node walker = head;
    // Counter to track a node position
    int counter = 0;

    while (walker != null && counter != index) {
      walker = walker.getNext();
      counter++;
    }

    return walker.getData();
  }

  /* Return the list as a string */
  public String toString() { // Overwriting built-in toString
    // Create a reference to head. It will help loop through the list
    Node walker = head;
    String list = "";

    while (walker != null) {
      list += walker.toString();
      walker = walker.getNext();
    }

    list += "null";
    return list;
  }

  /* Returns the number of elements in the list */
  public int size() {
    int len = 0;
    Node walker = head;

    while (walker != null) {
      walker = walker.getNext();
      len++;
    }

    return len;
  }


  /*Adds a new node which contains value at index */
  public void add(int index, String value){
    Node temp = new Node(value); // Similar to add at front method
    Node walker = head;
    int counter = 0;

    while (counter != index - 1) {
      walker = walker.getNext();
      counter++;
    }

    temp.setNext(walker.getNext());
    walker.setNext(temp);
  }


  /* Returns the index of the first node in the list that contains value. */
  public int indexOf(String value) {
    int index = 0;
    Node walker = head;

    while (walker != null && !walker.getData().equals(value)) { // While walker isn't null and walker data DOESN'T equal value...
      walker = walker.getNext();
      index++;
    }

    return index;
  }


  /* Remove node at location index */
  public void remove(int index) {
    Node prev = null;
    Node current = head;
    
    for (int i = 0; i < index; i++) {
        prev = current;
        current = current.getNext();
    }

    prev.setNext(current.getNext());
  }
}

