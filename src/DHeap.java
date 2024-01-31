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

    public void buildHeap(int[] elements) {
        if (elements.length > MAX_SIZE) {
            System.out.println("The max size of elements is " + MAX_SIZE);
            return;
        }

        for (int element : elements)
            insertNewElement(element);
    }

    private void insertNewElement(int newElement) {
        // this.size++;
        int newIndex = this.size;
        this.heap[size] = Integer.MAX_VALUE;

        // check: if the newly inserted elmment is greater than MAX VAlue
        if (newElement > Integer.MAX_VALUE) {
            System.out.println("One or more of the elements is greater than the MAX value allowed");
            return;
        }

        this.heap[newIndex] = newElement;

        int parentIndex = getParentIndex(newIndex);
        while (newIndex > 0 && this.heap[parentIndex] > newElement) {
            swap(newIndex, parentIndex);
            newIndex = parentIndex;
            parentIndex = getParentIndex(newIndex);
        }
    }

    // GPT version, need to check
    private void heapify(int index) {
        int smallest = index; // Initialize the smallest as root
        int[] children = new int[d]; // Array to hold indices of children

        // Find indices of all children of the node at index
        for (int k = 1; k <= d; ++k) {
            children[k - 1] = getChildIndex(index, k);
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
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    private int getChildIndex(int index, int k) {
        return this.d * index + k;
    }

    private int getParentIndex(int index) {
        // Is that ערך תחתון ?
        return Math.floorDiv(index - 1, this.d);
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
        String tab = "\t";
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
