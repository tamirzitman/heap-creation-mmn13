import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int[] readUserArray(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String[] userInput = scanner.nextLine().split(" ");
                return convertArrayToInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }
        }
    }

    public int readUserNumber(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }
        }
    }

    public void printInstruction() {
        System.out.println(
                """
                        \nThe possible actions are:
                        1. Build new Heap (overriding any existing heap)
                        2. Remove element on index i from the heap
                        3. Increase certain k value into index i
                        4. Insert new element with k value into the heap
                        5. Extracting the Max value from the heap
                                        
                        """
        );
    }

    private static int[] convertArrayToInt(String[] elements) {
        int[] newArr = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            newArr[i] = Integer.parseInt(elements[i]);
        }
        return newArr;
    }
}