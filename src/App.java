public class App {

    public static void main(String[] args) {
        System.out.println("Hi, Welcome to Maman13, Almog Shtaigmann & Tamir Zitman");
        int d;

        InputHandler inputHandler = new InputHandler();

        try {
            // Get the d value from the user
            d = inputHandler.readUserNumber("Enter d for d-ary Heap:");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for d. Exiting program.");
            return;
        }

        System.out.println("Let's build our first d-ary Heap!");
        DHeap h = new DHeap(d);
        h = buildNewHeap(inputHandler, h, true);

        while (true) {
            /*
             * The possible actions are:
             * 1. Build new Heap (overriding any exisiting heap)
             * 2. Remove element on index i from the heap
             * 3. Increace certain k value into index i
             * 4. Insert new element with k value into the heap
             * 5. Extracting the Max value from the heap
             *
             * Any other number - exit the program
             */
            int userAction = inputHandler.readUserNumber("Enter the action (1-5, or any other number to exit):");

            switch (userAction) {
                case 1:
                    System.out.printf("Let's build a new d-ary (%d-ary) Heap!%n%n", d);
                    h = buildNewHeap(inputHandler, h, true);
                    break;

                case 2:
                    System.out.printf("Let's remove the element on index i from our d-ary (%d-ary) Heap!%n%n", d);
                    h = removeElementiFromHeap(inputHandler, h, true);
                    break;

                case 3:
                    // Add case 3 logic
                    break;

                case 4:
                    // Add case 4 logic
                    break;

                case 5:
                    // Add case 5 logic
                    break;

                default:
                    System.out.println("Exiting program.");
                    return;
            }
        }
    }

    private static DHeap buildNewHeap(InputHandler inputHandler, DHeap h, boolean printNewHeap) {
        int[] heapElements = inputHandler.readUserArray(
                "Enter numbers to build the d-ary Heap, seperated by a single space between each number:");
        h.buildHeap(heapElements);
        if (printNewHeap) {
            h.printHeap();
        }
        return h;
    }

    private static DHeap removeElementiFromHeap(InputHandler inputHandler, DHeap h, boolean printNewHeap) {
        int removalIndex = inputHandler.readUserNumber("Enter an index to remove the elment from our d-ary Heap");
        // h.removeIndex(removalIndex);

        return h;
    }
}