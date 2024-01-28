public class DHeap {
    final private int MAX_SIZE = 5000;
    private int d;
    private int size;
    private int[] heap;

    public DHeap(int d) {
        if (d > 1) this.d = d;
        else {
            System.out.println("The d is 1 or less");
            return;
        }
        this.heap = new int[MAX_SIZE];
        this.size = 0;
    }

    public void buildHeap(int[] elements) {
        if (elements.length > MAX_SIZE) {
            System.out.println("The max size of elements is " + MAX_SIZE);
            return;
        }
        //Copy the giving array to heap array
        System.arraycopy(elements, 0, heap, 0, elements.length);
        size = elements.length;

        // Start from the last non-leaf node and heapify each node
        for (int i = parent(size - 1); i >= 0; i--) {
            heapify(i);
        }

    }

    private void heapify(int index) {
        int smallest = index; // Initialize the smallest as root
        int[] children = new int[d]; // Array to hold indices of children

        // Find indices of all children of the node at index
        for (int k = 1; k <= d; ++k) {
            children[k - 1] = child(index, k);
            if (children[k - 1] < size && heap[children[k - 1]] < heap[smallest]) {
                smallest = children[k - 1];
            }
        }

        // If the smallest is not root, swap it with root and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int child(int index, int k) {
        return d * index + k;
    }

    private int parent(int index) {
        return Math.floorDiv(index - 1, d);
    }


    public String toString() {
        return "temp";
    }
}
