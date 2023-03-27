public class Stack {
    // This Stack class is designed for integer values >= 0
    
    // Instance variables
    private Node top;
    private int size;
  
    // Constructor
    public Stack() {
      top = null;
      size = 0;
    }   
  
    // Add element to stack
    public void push(int value) {
      Node newNode = new Node(value);
      newNode.setNext(top);
      top = newNode;

      size++;
    }
  
    // Remove element from stack  
    public int pop() {
      if (isEmpty()) throw new IllegalStateException("Empty Stack");
      
      int value = top.getValue();
      top = top.getNext();
      size--;
      return value;
    }
  
    // Get top element
    public int top() {
      if (isEmpty()) throw new IllegalStateException("Empty Stack");
      return top.getValue();
    }
  
    // Check if stack is empty
    public boolean isEmpty() {
      return (top == null);
    }
  
    // Return size of stack
    public int size() {
      return size;
    }
    
    // Print stack
    public String toString() { // Makes it look like a Python list (I'm used to that)
        if (isEmpty()) return "[]";

        String result = "[";
        Node current = top;
        while (current != null) {
          result += current.getValue();

          if (current.getNext() != null) result += ", ";
          current = current.getNext();
        }
        result += "]";

        return result;
    }
}
