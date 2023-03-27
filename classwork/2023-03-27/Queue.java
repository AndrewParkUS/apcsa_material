public class Queue {
    // This Queue class is designed for integer values >= 0
    
    // Instance variables
    private Node front;
    private Node back;
    private int size;
  
    // Constructor
    public Queue() {
      front = null;
      back = null;
      size = 0;
    }
  
    // Enqueue a new value to the queue
    public void enqueue(int value) {
      Node newNode = new Node(value);

      if (isEmpty()) {
        front = newNode;
        back = newNode;
      } else {
        back.setNext(newNode);
        back = newNode;
      }

      size++;
    }
  
    // Dequeue a value from the queue
    public int dequeue() {
      if (isEmpty()) throw new IllegalStateException("Queue is empty");

      int value = front.getValue();
      front = front.getNext();
      size--;

      if (isEmpty()) back = null;
      return value;
    }
  
    // Return the front/top
    public int front() {
      if (isEmpty()) throw new IllegalStateException("Queue is empty");
      return front.getValue();
    }
  
    // Check if queue is empty
    public boolean isEmpty() {
      return (front == null);
    }
  
    // Return queue size
    public int size() {
      return size;
    }
  
    // Print queue
    public String toString() {
        if (isEmpty()) return "[]";

        String result = "[";
        Node current = front;
        while (current != null) {
          result += current.getValue();
          if (current.getNext() != null) result += ", ";
          current = current.getNext();
        }
        result += "]";

        return result;
    }
}
  