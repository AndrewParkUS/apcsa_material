import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    MyLinkedList myList = new MyLinkedList();
    
    // 1. Testing add (at front)
    myList.add("banana");
    System.out.println("Testing Add: " + myList); // Testing toString implicitly

    // 2. Testing get
    System.out.println("Testing Get: " + myList.get(0));

    // 3. Testing size
    System.out.println("Testing Size: " + myList.size());

    // 4. Testing add (at index)
    myList.add(1, "apple");
    System.out.println("Testing Add at Index: " + myList);

    // 5. Testing indexOf
    System.out.println("Testing indexOf: " + myList.indexOf("banana"));

    // 6. Testing remove
    myList.remove(1);
    System.out.println("Testing Remove: " + myList);

  }
}
