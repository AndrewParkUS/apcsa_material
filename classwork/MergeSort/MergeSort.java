public class MergeSort {
  public static void MergeSort (int[] destination, int[] left, int[] right) {
    if (left.length + right.length == destination.length) { // Is this logical?
        merge(destination, left, right);
    } else { 
      // Unfinished
    }

  }

  public static int[] merge(int[] left, int[] right) {
    // returnarray will be returned, leftindex indexes "through" left, rightindex indexes "through" right, allindex goes "through" both
    int[] returnarray = new int[left.length + right.length];
    int leftindex = 0;
    int rightindex = 0;
    int allindex = 0;

    // Comparing equal index elements from both
    while (leftindex < left.length && j < right.length) {

      if (left[leftindex] <= right[rightindex]) { 
        // If left's element is less than right (or equal)
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

    // Looping through the remaining elements that weren't added
    while (leftindex < left.length) { // For left list
        returnarray[allindex] = left[leftindex];
        leftindex++;
        allindex++;
    }

    while (rightindex < right.length) { // Same idea as above but for right list
        returnarray[allindex] = right[rightindex];
        rightindex++;
        allindex++;
    }

    return returnarray; // Return merged array
  }
}
