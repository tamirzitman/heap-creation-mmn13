import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int[] ReadUserArray() {
        try {
            System.out.println("Enter numbers to build the d-ary Heap, add space between each number");
            String[] userInput = scanner.nextLine().split(" ");
            return convertArrayToInt(userInput);
        }
        catch(NumberFormatException e){
            System.out.println("invalid input, try again");
            return ReadUserArray();
        }
    }

    public int ReadUserIntput() {
        try {

            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid input, try again");
            return ReadUserIntput();
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
