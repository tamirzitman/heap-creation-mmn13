public class App {

    public static void main(String[] args) {
        System.out.println("Hi, Welcome to Maman13, Almog Shtaigmann & Tamir Zitman");
        int d;
        InputHandler inputHandler = new InputHandler();

        try {
            // Get the d value from the user
            d = inputHandler.readUserInput("Enter d for d-ary Heap:");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for d. Exiting program.");
            return;
        }

        System.out.println("Let's build our first d-ary Heap!");
        buildNewHeap(inputHandler, d);

        while (true) {
            /*
             * The possible actions are:
             * 1. Build new Heap (overriding any exisiting heap)
             * 2. Remove element with k value from the heap
             * 3. Insert new element with k value into the heap
             * 4. Extracting the Max value from the heap
             * 5. Increace certain key value
             *
             * Any other key - exit the program
             */
            int userAction = inputHandler.readUserInput("Enter the action (1-5, or any other number to exit):");

            switch (userAction) {
                case 1:
                    System.out.printf("Let's build a new d-ary (%d-ary) Heap!%n%n", d);
                    buildNewHeap(inputHandler, d);
                    break;

                case 2:
                    System.out.printf("Let's remove element k from our d-ary (%d-ary) Heap!%n%n", d);
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

    private static void buildNewHeap(InputHandler inputHandler, int d) {
        int[] heapElements = inputHandler.readUserArray(
                "Enter numbers to build the d-ary Heap, seperated by a single space between each number:");
        DHeap h = new DHeap(d);
        h.buildHeap(heapElements);
        h.printHeap();
    }
}