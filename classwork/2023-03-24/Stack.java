public class Stack{
  // This Stack class is designed for integer values >= 0

  // Instance variables here
  private Node top;
  private int size;
  
  // Constructor
  public Stack(){
    top = null;
    size = 0;
  }   

  // Add element to stack
  public void push(int value){ // Value to top of stack

    return value;
  }

  // Remove element from stack  
  public int pop(){
    
    return value; // Return value of the element we're removing
  }

  // Get top element
  public int top(){
    if (isEmpty()) {
      return -1; // Error? Exception?
    }
    return top.value; // Do we need to check if it's empty?
  }

  // Check if stack is empty
  public boolean isEmpty(){
    return (top == null); 
  }

  // Return size stack
  public int size(){
    return size;
  }

  // Print stack
  public String toString(){
    String stack;
   
    return stack;
  }


}
