import java.util.Random;

public class QuickSelect {
    
    public static int QuickSelect (int[] data, int start, int end, int k) {
        int pivot = partition(data, start, end);
        
        if (pivot > k-1) {
            QuickSelect (data, start, pivot-1, k);
        } else if (pivot < k-1) {
            QuickSelect (data, pivot+1, end, k);
        } else {
            // kth element found
            return data[k-1];
        }
    }
    
    public static int partition (int[] data, int start, int end) {
        Random random = new Random();   
        int pivot = (int) (Math.random() * (end-start)) + start;
        
        if (pivot != start) {
            swap(data[pivot], data[start]);
            start++;
        }
        
        while (start != end) {
            if (data[start] > data[pivot]) {
                swap(data[start], data[end]);
                end--;
            } else {
                start++;
            }
        }
        
        if (data[start] <= data[pivot]) {
            swap(data[start], data[pivot]);
            pivot = start;
        } else {
            swap(data[start-1],data[pivot]);
            pivot = start - 1;
        }
        
        return pivot;     
    }
    
    public static void swap(int[] data, int swap1, int swap2 ) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}