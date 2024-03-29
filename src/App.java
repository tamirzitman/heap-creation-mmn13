public class App {
    static InputHandler inputHandler = new InputHandler();

    public static void main(String[] args) {
        System.out.println("Hi, Welcome to Maman13, Almog Shtaigmann & Tamir Zitman");

        int d;
        try {
            // Get the d value from the user
            d = inputHandler.readUserNumber("Enter d for d-ary Heap:");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for d- run again the program. Exiting.");
            return;
        }

        System.out.println("Let's build our first d-ary Heap!");
        DHeap h = new DHeap(d);
        buildNewHeap(h);

        while (true) {
            /*
             * The possible actions are:
             * 1. Build new Heap (overriding any existing heap)
             * 2. Remove element on index i from the heap
             * 3. Increase certain k value into index i
             * 4. Insert new element with k value into the heap
             * 5. Extracting the Max value from the heap
             *
             * Any other number - exit the program
             */
            inputHandler.printInstruction();
            int userAction = inputHandler.readUserNumber("Enter the action (1-5, or any other number to exit):");

            switch (userAction) {
                case 1: buildNewHeap(h); break;
                case 2: removeElementFromHeap(h); break;
                case 3: increaseKey(h); break;
                case 4: insertMemember(h); break;
                case 5: extractMaxElementFromHeap(h); break;
                default: System.out.println("Exiting program."); return;
            }
        }
    }

    private static void insertMemember(DHeap h) {
        System.out.printf("Let's insert new element into our d-ary (%d-ary) Heap!%n%n", h.getD());
        int newMember = inputHandler.readUserNumber("Enter the member value:");
        h.insertNewElement(newMember);
    }

    private static void buildNewHeap(DHeap h) {
        System.out.printf("Let's build a new d-ary (%d-ary) Heap!%n%n", h.getD());
        if (h.getSize() > 0) {
            h = new DHeap(h.getD());
        }
        int[] heapElements = inputHandler.readUserArray(
                "Enter numbers to build the d-ary Heap, seperated by a single space between each number:");
        h.buildHeap(heapElements);
        System.out.println(h);
    }

    private static void removeElementFromHeap(DHeap h) {
        System.out.printf("Let's remove the element on index i from our d-ary (%d-ary) Heap!%n%n", h.getD());
        int removalIndex = inputHandler.readUserNumber("Enter an index to remove the element from our d-ary Heap");
        h.removeIndex(removalIndex);
        System.out.println(h);
    }

    private static void extractMaxElementFromHeap(DHeap h) {
        System.out.printf("Let's extract the element from our d-ary (%d-ary) Heap!%n%n", h.getD());
        int maxElement = h.extractMax();
        System.out.printf("%d was removed", maxElement);
        System.out.println(h);
    }

    private static void increaseKey(DHeap h) {
        System.out.printf("Let's increase the element on index i from our d-ary (%d-ary) Heap!%n%n", h.getD());
        int increaseIndex = inputHandler.readUserNumber("Enter an index to increase the element from our d-ary Heap");
        int increaseKey = inputHandler.readUserNumber("Enter a ket to increase the element from our d-ary Heap");

        h.increaseKey(increaseIndex, increaseKey);
        System.out.println(h);
    }
}