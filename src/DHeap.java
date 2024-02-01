/**
 * DHeap: A Flexible d-ary Heap Implementation
 * <p>
 * Overview:
 * It's like a regular heap, but each node can have 'd' kids, not just two. This makes for some
 * nifty, efficient ways to access the biggest item and do stuff like adding or removing elements.
 * <p>
 * What's Inside:
 * - 'heap': Just an array where all the heap magic happens.
 * - 'size': Keeps track of how many things are in the heap.
 * - 'd': This is how many children each node gets to have.
 * <p>
 * Key Actions:
 * - 'insertNewElement' adds it to the heap.
 * - Need to bump up an element's value? 'increaseKey' has you covered.
 * - 'heapify' keeps everything in order, especially after taking stuff out.
 * - Grab the biggest item with 'extractMax'.
 * - Toss out something specific with 'removeIndex'.
 * - 'swap' does the old switcheroo with two elements.
 * - Finding parents and kids is easy with 'getChildIndex' and 'getParentIndex'.
 */
public class DHeap {
    final private int MAX_SIZE = 5000;
    private int d;
    private int size;
    private int[] heap;

    /**
     * Constructor for DHeap.
     *
     * @param d The number of children each node in the heap can have.
     */
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


    /**
     * Gets the value of d in the d-ary heap.
     *
     * @return The number of children per node.
     */
    public int getD() {
        return this.d;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Builds the heap from an array of elements.
     *
     * @param elements Array of elements to build the heap from.
     */
    public void buildHeap(int[] elements) {
        if (elements.length > MAX_SIZE) {
            System.out.println("The max size of elements is " + MAX_SIZE);
            return;
        }

        for (int element : elements)
            insertNewElement(element);
    }

    /**
     * Inserts a new element into the heap.
     *
     * @param newElement The element to be inserted into the heap.
     */
    public void insertNewElement(int newElement) {
        int newIndex = this.size;
        this.size++;
        this.heap[newIndex] = Integer.MIN_VALUE;

        increaseKey(newIndex, newElement);
    }

    /**
     * Increases the key at a given index in the heap.
     *
     * @param i Index at which the key needs to be increased.
     * @param k The new key value which is greater than the current key value at index i.
     */
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

    /**
     * Maintains the heap property by restructuring the heap downwards from the given index.
     *
     * @param i The index from which to start the heapify process.
     */
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

    /**
     * Extracts the maximum element from the heap.
     *
     * @return The maximum element from the heap.
     */
    public int extractMax() {
        int maxElement;
        maxElement = this.heap[0];

        // Set last element at heap in the first indx
        this.heap[0] = this.heap[this.size - 1];

        this.size--;

        heapify(0);

        return maxElement;
    }

    /**
     * Removes an element at a specified index from the heap.
     *
     * @param removalIndex The index of the element to be removed.
     */
    public void removeIndex(int removalIndex) {
        // Trying to access the selected index
        if (removalIndex >= this.size) {
            System.out.print("Can't get the removal index - invalid index in Heap!%n%n");
            return;
        }

        int removalValue = this.heap[removalIndex];
        System.out.printf("Value to be removed in index %d -> %d %n", removalIndex, removalValue);

        // Swapping the element with the last item
        int lastInd = this.size - 1;
        swap(removalIndex, lastInd);

        // deleting Last Element
        this.size--;

        // Heapify the replaced index
        heapify(removalIndex);
    }


    /**
     * Swaps two elements in the heap.
     *
     * @param i First element index to swap.
     * @param j Second element index to swap.
     */

    private void swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    /**
     * Calculates the child index for a given node index and child number.
     *
     * @param index The index of the parent node.
     * @param j     The child number (1st, 2nd, ..., dth).
     * @return The index of the jth child of the node at the given index.
     */
    private int getChildIndex(int index, int j) {
        return (index - 1) * this.d + j;
    }

    /**
     * Calculates the parent index for a given node index.
     *
     * @param index The index of the child node.
     * @return The index of the parent of the node at the given index.
     */
    private int getParentIndex(int index) {
        return Math.floorDiv(index + this.d - 2, this.d) - 1;
    }

    /**
     * Calculates the height of the heap.
     *
     * @return The height of the heap.
     */
    private int getTreeHeight() {
        return (int) Math.ceil((Math.log(this.size * (this.d - 1) + 1) / Math.log(this.d)) - 1);
    }

    /**
     * Calculates the number of elements at a given level of the heap.
     *
     * @param level The level in the heap.
     * @return The number of elements at the given level.
     */
    private int getNumberOfElementsForLevel(int level) {
        return (int) Math.pow(this.d, level);
    }

    /**
     * Calculates the index of the first element at a given level of the heap.
     *
     * @param level The level in the heap.
     * @return The index of the first element at the given level.
     */
    private int getFirstElementInLevel(int level) {
        int numerator = (int) (1 - Math.pow(this.d, level));
        int denominator = 1 - this.d;
        return numerator / denominator;
    }

    @Override
    public String toString() {
        StringBuilder heapTree = new StringBuilder();
        String tab = "\t\t";
        String space = " ";
        int firstElementInLevelIndex;

        heapTree.append("The Tree is: \n");
        for (int level = 0; level <= getTreeHeight(); level++) {
            firstElementInLevelIndex = getFirstElementInLevel(level);
            heapTree.append("Elements in level:").append(level).append("-> ");

            for (int elementIndexInHeap = firstElementInLevelIndex,
                 elementCounter = 0; elementCounter < getNumberOfElementsForLevel(level)
                         && elementIndexInHeap < size; elementIndexInHeap++, elementCounter++) {
                heapTree.append(heap[elementIndexInHeap]);
                heapTree.append(space);
            }
            heapTree.append(tab);
        }

        return heapTree.toString();
    }
}