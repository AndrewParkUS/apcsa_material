public class MyDeque<E>{
    @SuppressWarnings("unchecked")
    // Instance variables
    private E[] data;
    private int size;
    private int start, end;

    // Constructors
    public MyDeque(){ 
      data = (E[])new Object[size];
      size = 0;
      start = 0;
      end = 0;
    }

    public MyDeque(int initialCapacity){ 
       data = (E[])new Object[initialCapacity];
       size = 0;
       start = 0;
       end = 0;
    }
    
    // Add a new value on the indicated side
    public void addFirst(E element) {

        // No return value
    }
    public void addLast(E element) { 

        // No return value
    }
    
    // Remove and return the element
    public E removeFirst() { 

        // Return removed element

    }
    public E removeLast() { 

        // Return removed element
    }
    
    // Return the element. Do not deleter elements.
    public E getFirst() {

        // Return first element
     }
    public E getLast() { 

        // Return last element
    }
    
    // Return deque size
    public int size() { 
        return size;
    }
    
    // Getters

    // Return data
    public E[] getData() {
        return data;
    }
    // Return start
    public int getStart() { 
        return start;
    }
    // Return end
    public int getEnd() { 
        return end;
    }
    
    // Resize the array. Double its length (data.length * 2)
    private void resize() { // Is size synonymous to length?
        int newsize = size * 2;
        data = MyDeque(newsize); // Pseudocode
    }
    
    // Return the deque as string. Ex.:  "[hello, my, dear, friends!]"
    public String toString() {
        String stringified = "["; // Python style representation
        for (int i = 0; i < size; i++) { // For i in data
            stringified += getStart() + ", ";
            // Iterate so we print the front of a successively smaller and smaller array
            // We don't want to modify the array though
        }
        stringified += "]";
    }
  }
