import java.util.Scanner;

public class App {

    public static int[] convertArrayToInt(String[] elements) {
        int[] newArr = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            newArr[i] = Integer.parseInt(elements[i]);
        }
        return newArr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hi, Welcome to Maman13, Almog Shtaigmann & Tamir Zitman");
        boolean isOver = false;
        int d;
        Scanner scanner = new Scanner(System.in);
        /*
        The possible action are:
        1. Build new Heap
        2. Remove element k from the heap
        3. Insert new element k into the heap
        4.
        5.
        6.
        7.
        8.
        9.
        10. exit the program
         */
        int userAction = 1;

        while (!isOver) {


            switch (userAction) {
                case -1:
                    System.out.println("Choose what you wan to do:");
                    System.out.println("1- Build new d-ary Heap");
                    System.out.println("3-");
                    System.out.println("4-");
                    System.out.println("5-");

                    try {
                        userAction = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid action");
                    }

                case 1:
                    System.out.println("Lest build new d-ary Heap!");
                    System.out.println("Enter d for d-ary Heap:");

                    d = Integer.parseInt(scanner.nextLine());
                    DHeap h = new DHeap(d);

                    System.out.println("Enter numbers to build the d-ary Heap, add space between each number");
                    String[] userInput = scanner.nextLine().split(" ");
                    h.buildHeap(convertArrayToInt(userInput));
                    userAction = -1;

                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    break;

            }


        }
    }


}
