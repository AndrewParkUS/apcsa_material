public class MyHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MyHeap(int numElements) {
        // We start our heap from index 0 (not 1).
        maxsize = numElements;
        size = 0;
        Heap = new int[maxsize + 1];
    }

    private int parent(int pos) {
        // RETURN POSTION PARENT
        return 0;
    }

    private int leftChild(int pos) {
        // RETURN POSITION LEFTCHILD
        return 0 ;
    }

    private int rightChild(int pos) {
        // RETURN POSITION LEFTCHILD
        return 0 ;
    }


    private void swap(int index1, int index2) {
        // the parameters are the indexes
        int temp = Heap[index1];
        Heap[index1] = Heap[index2];
        Heap[index2] = temp;
        // YOUR CODE HERE
    }

    private void downHeapify(int pos) {
        if (pos >= (size / 2) && pos <= size)
            return;

        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

            // YOUR CODE HERE
        }
    }
    
    private void heapifyUp(int pos) {
        int temp = Heap[pos];
        while(pos>0 && temp > Heap[parent(pos)]){
            // YOUR CODE HERE
        }
        Heap[pos] = temp;
    }


    public void insert(int element) {
        // YOUR CODE HERE

    }

    public void print() {
        // YOUR CODE HERE
        for (int index = 0; index < Heap.length; index++) {
            System.out.print(Heap[index] + ", ");
        }
    }

    public int deleteRoot() {
        int root;
        // YOUR CODE HERE
        return root;
    }

}
