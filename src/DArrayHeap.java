public class DArrayHeap {
    private int[] heap;
    private int size;
    private final int d;

    public DArrayHeap( int d) {
        heap = new int[5000];
        this.size = 0;
        this.d = d;
    }
    public DArrayHeap(int d, int[] elements){
        this(d);
        this.heap = elements;
        this.size = elements.length;
    }

    private int parent(int i) {
        return (i + d - 2) / d;
    }

    private int child(int i, int j) {
        return (i - 1) * d + j + 1;
    }

    public void heapify(int i) {
        int largest = i;
        for (int j = 1; j <= d; j++) {
            int childIndex = child(i, j);
            if (childIndex <= size && heap[childIndex] > heap[largest]) {
                largest = childIndex;
            }
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public void insert(int key) {
        if (size == heap.length) {
            // Handle the heap overflow or resize the heap
            return;
        }

        size++;
        int i = size;
        while (i > 1 && heap[parent(i)] < key) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = key;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Additional methods (like extractMax, buildHeap, etc.) can be added as needed
}
