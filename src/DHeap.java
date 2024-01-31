import java.util.ArrayList;
import java.util.List;

public class DHeap {
    final private int MAX_SIZE = 5000;
    private int d;
    private int size;
    private int[] heap;

    public DHeap(int d) {
        if (d > 1)
            this.d = d;
        else {
            System.out.println("The d is 1 or less");
            return;
        }
        this.heap = new int[MAX_SIZE];
        this.size = 0;
    }

    public DHeap(int d, int[] heap) {
        this(d);
        this.heap = heap;
        this.size = heap.length;
    }

    public int getD() {
        return this.d;
    }

    public void buildHeap(int[] elements) {
        if (elements.length > MAX_SIZE) {
            System.out.println("The max size of elements is " + MAX_SIZE);
            return;
        }

        for (int element : elements)
            insertNewElement(element);
    }

    // public void removeIndex(int removalIndex) {
    // if (removalIndex > this.size) {
    // System.out.println("The index is not in the size of elements is " +
    // MAX_SIZE);
    // return;
    // }
    // try {
    // // Trying to get the value from removal index
    // removalValue =this.heap[removalIndex];
    // } catch () {
    // System.out.println("Invalid i")
    // }
    // }

    private void insertNewElement(int newElement) {
        int newIndex = this.size;
        this.size++;
        this.heap[newIndex] = Integer.MIN_VALUE;

        increaseKey(newIndex, newElement);
    }

    public void increaseKey(int i, int k) {
        if (k <= this.heap[i] || i >= this.size) {
            System.out.println("Skipping an element, invalid key or index");
            return;
        }

        this.heap[i] = k;

        int parentIndex = getParentIndex(i + 1);
        while (i > 0 && this.heap[parentIndex] < k) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = getParentIndex(i + 1);
        }

    }

    public void maxHeapify(int indexToHeapifyFrom) {
        int maxElementIndex = indexToHeapifyFrom;

        // Find index of max element of current node childrens
        for (int childNumber = 0; childNumber < this.d; childNumber++) {
            int childIndexInHeapArray = ChildIndex(indexToHeapifyFrom, childNumber);

            // Update value of max element index to current child index if he's larger than
            // value in maxElementIndex
            if (childIndexInHeapArray < size && heap[childIndexInHeapArray] > heap[maxElementIndex]) {
                maxElementIndex = childIndexInHeapArray;
            }
        }

        // Swap if max element is in different index
        if (maxElementIndex != indexToHeapifyFrom) {
            swap(maxElementIndex, indexToHeapifyFrom);

            maxHeapify(maxElementIndex);
        }
    }

    public void heapify(int i) {
        int largest = i;
        for (int l = getChildIndex(i + 1, 1); l <= getChildIndex(i + 1, d); l++) {
            if (l < this.size && this.heap[l] > this.heap[largest]) {
                largest = l;
            }
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public int extractMax() {
        int maxElement;

        maxElement = heap[0];

        // Set last element at heap in first index
        heap[0] = heap[size - 1];

        size--;

        maxHeapify(0);

        return maxElement;
    }

    public void removeIndex(int removalIndex) {
        // Trying to access the selected index
        try {
            int removalValue = this.heap[removalIndex];
            System.out.printf("Value to be removed is %d %n", removalValue);
        } catch (Exception e) {
            System.out.print("Can't get the removal index - Failed to remove the element on index i from Heap!%n%n");
        }

        // Swapping the element with the last item
        int lastInd = this.size - 1;
        swap(removalIndex, lastInd);

        // deleting Last Element
        this.size--;

        // Heapify the replaced
        heapify(removalIndex);
    }


    private void swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    public int ChildIndex(int i, int j) {
        return ((d * i) + j + 1);
    }

    private int getChildIndex(int index, int j) {
        return (index - 1) * this.d + j;
    }

    private int getParentIndex(int index) {
        return Math.floorDiv(index + this.d - 2, this.d) - 1;
    }

    private int getTreeHeight() {
        return (int) Math.ceil((Math.log(this.size * (this.d - 1) + 1) / Math.log(this.d)) - 1);
    }

    private int getNumberOfElementsForLevel(int level) {
        return (int) Math.pow(this.d, level);
    }

    private int getFirstElementInLevel(int level) {
        int numerator = (int) (1 - Math.pow(this.d, level));
        int denominator = 1 - this.d;
        return numerator / denominator;
    }

    public void printHeap() {
        StringBuilder heapTree = new StringBuilder();
        String tab = "\t\t";
        String space = " ";
        int firstElementInLevelIndex;

        heapTree.append("The Tree is: \n");
        for (int level = 0; level <= getTreeHeight(); level++) {
            firstElementInLevelIndex = getFirstElementInLevel(level);

            for (int elementIndexInHeap = firstElementInLevelIndex,
                 elementCounter = 0; elementCounter < getNumberOfElementsForLevel(level)
                         && elementIndexInHeap < size; elementIndexInHeap++, elementCounter++) {
                heapTree.append(heap[elementIndexInHeap]);
                heapTree.append(space);
            }
            heapTree.append(tab);
        }

        System.out.println(heapTree.toString());
    }
}
