import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hi, Welcome to Maman13, Almog Shtaigmann & Tamir Zitman");
        boolean isOver = false;
        int d;
        InputHandler inputHandler = new InputHandler();
        /*
         * The possible action are:
         * 1. Build new Heap
         * 2. Remove element k from the heap
         * 3. Insert new element k into the heap
         * 4.
         * 5.
         * 6.
         * 7.
         * 8.
         * 9.
         * 10. exit the program
         */
        int userAction = 1;

        while (!isOver) {

            switch (userAction) {
                case -1:
                    System.out.println("Choose what you want to do:");
                    System.out.println("1 - Build new d-ary Heap");
                    System.out.println("3 -");
                    System.out.println("4 -");
                    System.out.println("5 -");

                    try {
                        userAction = inputHandler.ReadUserIntput();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid action");
                    }

                case 1:
                    System.out.println("Let's build a new d-ary Heap!");
                    System.out.println("Enter d for d-ary Heap:");
                    d = inputHandler.ReadUserIntput();
                    DHeap h = new DHeap(d);

                    int[] heapElements = inputHandler.ReadUserArray();
                    h.buildHeap(heapElements);

                    System.out.println(h);
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
