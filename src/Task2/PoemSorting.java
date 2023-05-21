package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PoemSorting {
    public static void PoemSorting() {
        List<String> poemNames = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter poem names (one per line, enter 'done' to finish):");
        String poemName;
        while (true) {
            poemName = scanner.nextLine();
            if (poemName.equalsIgnoreCase("done")) {
                break;
            }
            poemNames.add(poemName);
        }

        Collections.sort(poemNames, Comparator.comparingInt(String::length));

        System.out.println("Poem Names (Sorted by Increasing Length):");
        for (String name : poemNames) {
            System.out.println(name);
        }
    }
}
