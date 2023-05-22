//package Task2;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//
//public class PoemSorting {
//    private List<String> poemNames;
//
//    public PoemSorting() {
//        poemNames = new ArrayList<>();
//    }
//
//    public void poemsByInput() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter poem names (one per line, enter 'done' to finish):");
//        String poemName;
//        while (true) {
//            poemName = scanner.nextLine();
//            if (poemName.equalsIgnoreCase("done")) {
//                break;
//            }
//            poemNames.add(poemName);
//        }
//        scanner.close();
//    }
//
//    public void readPoemsFromFile(String filePath) {
//        try {
//            File file = new File(filePath);
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String poemName = scanner.nextLine();
//                poemNames.add(poemName);
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
//    }
//
//    public void sortPoemNamesByLength() {
//        Collections.sort(poemNames, Comparator.comparingInt(String::length));
//    }
//
//    public void printSortedPoemNames() {
//        System.out.println("Poem Names (Sorted by Increasing Length):");
//        for (String name : poemNames) {
//            System.out.println(name);
//        }
//    }
//
//    public void writeInFile(String filePath) {
//        try {
//            FileWriter writer = new FileWriter(filePath);
//            for (String poemName : poemNames) {
//                writer.write(poemName + System.lineSeparator());
//            }
//            writer.close();
//            System.out.println("Sorted poem names written to the file: " + filePath);
//        } catch (IOException e) {
//            System.out.println("Error occurred while writing to the file.");
//        }
//    }
//
//    public static void main(String[] args) {
//            PoemSorting poemSorting = new PoemSorting();
////        poemSorting.poemsByInput();
//            // poemSorting.readPoemsFromFile("src/Task2/poems.txt"); // Uncomment this line to read poems from file
//            poemSorting.sortPoemNamesByLength();
//            poemSorting.printSortedPoemNames();
//            poemSorting.writeInFile("src/Task2/sorted_poems.txt"); // Change the file name and path as needed
//        }
//}
//
package Task2;

import Validators.InputVal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PoemSorting {
    private List<String> poemNames;

    public PoemSorting() {
        poemNames = new ArrayList<>();
    }

    public void poemsByInput(Scanner scanner) {
        System.out.println("Enter poem names (one per line, enter 'done' to finish):");
        String poemName;
        while (true) {
            poemName = scanner.nextLine();
            if (poemName.equalsIgnoreCase("done")) {
                break;
            }
            poemNames.add(poemName);
        }
    }

    public void readPoemsFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String poemName = scanner.nextLine();
                poemNames.add(poemName);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void sortPoemNamesByLength() {
        Collections.sort(poemNames, Comparator.comparingInt(String::length));
    }

    public void printSortedPoemNames() {
        System.out.println("Poem Names (Sorted by Increasing Length):");
        for (String name : poemNames) {
            System.out.println(name);
        }
    }

    public void writeInFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (String poemName : poemNames) {
                writer.write(poemName + System.lineSeparator());
            }
            writer.close();
            System.out.println("Sorted poem names written to the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file.");
        }
    }

    public void showMenu(Scanner scanner) {
        int choice = 0;

        do {
            System.out.println("Choose the input method:");
            System.out.println("1. Enter poem names manually");
            System.out.println("2. Read poem names from a file");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    poemsByInput(scanner);
                    sortPoemNamesByLength();
                    printSortedPoemNames();
                    writeInFile("src/Task2/sorted_poems.txt");
//                    InputVal.validateIntegerInput(scanner);
                    break;
                case 2:
//                    System.out.print("Enter the file path: ");
//                    String filePath = scanner.nextLine();
//                    readPoemsFromFile(filePath);
                    System.out.println("Poems are read from: src/Task2/poems.txt");
                    readPoemsFromFile("src/Task2/poems.txt");
                    sortPoemNamesByLength();
                    printSortedPoemNames();
                    writeInFile("src/Task2/sorted_poems.txt");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
    }
}
