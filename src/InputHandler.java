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

    public int readUserInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }
        }
    }

    private static int[] convertArrayToInt(String[] elements) {
        int[] newArr = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            newArr[i] = Integer.parseInt(elements[i]);
        }
        return newArr;
    }
}
