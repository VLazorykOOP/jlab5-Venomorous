package Validators;

import java.util.Scanner;

public class InputVal {
//    Scanner scan = new Scanner(System.in);
    public static double validateDoubleInput(Scanner scan) {
        while (true) {
            if (scan.hasNextDouble()) {
                return scan.nextDouble();
            }
            System.out.println("Invalid input. Please enter a valid number.");
            scan.nextLine(); // Clear the invalid input from the buffer
        }
    }

    public static int validateIntegerInput(Scanner scan) {
        while (true) {
            if (scan.hasNextInt()) {
                return scan.nextInt();
            }
            System.out.println("Invalid input. Please enter a valid integer.");
            scan.nextLine(); // Clear the invalid input from the buffer
        }
    }
}
