public class MergeSort {
  public static int[] merge(int[] left, int[] right) {
    // NOT FINISHED
    // returnarray will be returned, leftindex indexing "through" left, rightindex indexing "through" right, allindex is "through" both
    int[] returnarray = new int[left.length + right.length];
    int leftindex = 0;
    int rightindex = 0;
    int allindex = 0;
        
    // Comparing equal index elements from both
    while (leftindex < left.length && j < right.length) {
      
      if (left[leftindex] <= right[rightindex]) { 
        // If left's element is less than right (or it's equal)
        returnarray[allindex] = left[leftindex];
        leftindex++; // Only increment i or j to keep comparing same element w/ other element
        allindex++;
      } else { 
        // If right's element is less than left
        returnarray[allindex] = right[rightindex];
        rightindex++;
        allindex++;
      }
      
    }
    
    // Still need to deal with the remaining elements that weren't added
    // More while loops? For loop?
    
    return returnarray;
  }
}
