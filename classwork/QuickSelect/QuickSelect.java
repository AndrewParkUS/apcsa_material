import java.util.*;

public class QuickSelect {
    public static void QuickSort (int[] data, int start, int end) {
        if (start < end) {
            pivot = partition(data, start, end);
            QuickSort(data, start, pivot - 1);
            QuickSort(data, pivot + 1, end);
        }
    }
    
    public static int QuickSelect (int[] data, int start, int end, int k) {
        int pivot = partition(data, start, end);
        
        if (pivot > k-1) {
            QuickSelect(data, start, pivot - 1, k);
        } else if (pivot < k - 1) {
            QuickSelect(data, pivot + 1, end, k);
        } else {
            return data[k - 1];
        }
    }
    
    public static int partition (int[] data, int start, int end) { 
        int pivot = (int) (Math.random() * (end - start)) + start;
        
        if (pivot != start) {
            swap(data, pivot, start);
            start++;
        }
        
        while (start != end) {
            if (data[start] > data[pivot]) {
                swap(data, start, end);
                end--;
            } else {
                start++;
            }
        }
        
        if (data[start] <= data[pivot]) {
            swap(data, start, pivot);
            pivot = start;
        } else {
            swap(data, start - 1, pivot);
            pivot = start - 1;
        }
        
        return pivot;     
    }
    
    public static void swap(int[] data, int swap1, int swap2) {
        int temp = data[swap1];
        data[swap1] = data[swap2];
        data[swap2] = temp;
    }
}
