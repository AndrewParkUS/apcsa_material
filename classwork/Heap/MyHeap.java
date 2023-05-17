public class MyHeap {
    // instance vars
    private int[] Heap;
    private int size;
    private int maxsize;

    // constructor!
    public MyHeap(int numElements) {
        maxsize = numElements;
        size = 0;
        Heap = new int[maxsize + 1];
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) { // basically opposite of parent
        return 2 * pos;
    }

    private int rightChild(int pos) { // same as leftchild but need to add 1
        return (2 * pos) + 1;
    }

    private void swap(int idx1, int idx2) {
        int temp = Heap[idx1]; // just like sorting algorithms
        Heap[idx1] = Heap[idx2];
        Heap[idx2] = temp;
    }

    private void downHeapify(int pos) {
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) { // or
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { // depends on the case, but same idea
                swap(pos, leftChild(pos)); 
                downHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                downHeapify(rightChild(pos));
            }
        }
    }

    private void heapifyUp(int pos) {
        int temp = Heap[pos]; // need temp to heapifyUp
        while (pos > 0 && temp > Heap[parent(pos)]) {
            Heap[pos] = Heap[parent(pos)];
            pos = parent(pos);
        }
        Heap[pos] = temp;
    }

    public void insert(int element) {
        if (size >= maxsize) // means we have a full heap!
            return;

        Heap[++size] = element; // i'm not 100% sure why, but w/ trial and error only prefix operator works
        int current = size;
        heapifyUp(current);
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.println(); // addline
    }

    public int deleteRoot() {
        int popped = Heap[1]; // first(second) ele
        Heap[1] = Heap[size--]; // postfix? not sure why not prefix here too like in line 57
        downHeapify(1); // it works though!
        return popped;
    }
}
