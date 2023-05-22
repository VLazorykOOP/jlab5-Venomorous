import Product.*;
import Validators.*;
import java.io.*;
import java.util.*;

import static Task2.PoemSorting.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String append;
        int choice = 0;

        do {
            System.out.println("Choose  the task to execute:");
            System.out.println("1. Task1");
            System.out.println("2. Task2");
            System.out.println("3. Exit");
            choice = InputVal.validateIntegerInput(scanner);
            switch (choice){
                case 1:
                    List<Product> products = new ArrayList<>();
                    List<Component> components = new ArrayList<>();

                    String componentsPath = "C:\\Users\\User\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\components.txt";

                    while (true) {
                        System.out.print("Enter the path to the components list file : ");
//            componentsPath = scanner.nextLine();
                        File republcsFile = new File(componentsPath);
                        if (!republcsFile.exists()) {
                            System.out.println("File not found.");
                        } else {
                            components = Product.readFromFile(componentsPath, Component.class);
                            if (!components.isEmpty()) {
                                break;
                            }
                        }
                    }

                    System.out.println("\nInformation from file: " + componentsPath);
                    System.out.println();
                    for (Component component : components) {
                        System.out.println("Component:");
                        component.show();
                        System.out.println();
                    }

                    System.out.println("\nSorted by price:\n");
                    Collections.sort(components);
                    for (Component component : components) {
                        component.show();
                        System.out.println();
                    }

                    System.out.print("Do you want to add a new component? (y/n) ");
                    scanner.next();
                    append = scanner.nextLine();

                    if (append.equalsIgnoreCase("y")) {
                        Component newComponent = Component.getComponentFromInput();
                        components.add(newComponent);
                        Product.writeToFile(componentsPath, newComponent);

                        System.out.println("\nSorted by price after adding:\n");
                        Collections.sort(components);
                        for (Component republic : components) {
                            republic.show();
                            System.out.println();
                            products.add(republic);
                        }
                    }

                    List<Mechanism> mechanisms = new ArrayList<>();

                    String mechanismsPath = "C:\\Users\\User\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\mechanisms.txt";

                    while (true) {
                        System.out.print("Enter the path to the mechanisms list file : ");
//            componentsPath = scanner.nextLine();
                        File mechanismsFile = new File(mechanismsPath);
                        if (!mechanismsFile.exists()) {
                            System.out.println("File not found.");
                        } else {
                            mechanisms = Product.readFromFile(mechanismsPath, Mechanism.class);
                            if (!mechanisms.isEmpty()) {
                                break;
                            }
                        }
                    }

                    System.out.println("\nInformation from file: " + mechanismsPath);
                    System.out.println();
                    for (Mechanism mechanism : mechanisms) {
                        mechanism.show();
                        System.out.println();
                    }

                    System.out.println("\nSorted by price:\n");
                    Collections.sort(mechanisms);
                    for (Mechanism mechanism : mechanisms) {
                        mechanism.show();
                        System.out.println();
                    }

                    System.out.print("Do you want to add a new mechanism? (y/n) ");
                    append = scanner.nextLine();

                    if (append.equalsIgnoreCase("y")) {
                        Mechanism newMechanism = Mechanism.getMechanismFromInput();
                        mechanisms.add(newMechanism);
                        Product.writeToFile(mechanismsPath, newMechanism);

                        System.out.println("\nSorted by price after adding:\n");
                        Collections.sort(mechanisms);
                        for (Mechanism mechanism : mechanisms) {
                            mechanism.show();
                            System.out.println();
                            products.add(mechanism);
                        }
                    }

                    List<Node> nodes = new ArrayList<>();

                    String nodesPath = "C:\\Users\\User\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\nodes.txt";

                    while (true) {
                        System.out.print("Enter the path to the nodes list file : ");
//            componentsPath = scanner.nextLine();
                        File nodesFile = new File(nodesPath);
                        if (!nodesFile.exists()) {
                            System.out.println("File not found.");
                        } else {
                            nodes = Product.readFromFile(nodesPath, Node.class);
                            if (!nodes.isEmpty()) {
                                break;
                            }
                        }
                    }

                    System.out.println("\nInformation from file: " + nodesPath);
                    System.out.println();
                    for (Node node : nodes) {
                        node.show();
                        System.out.println();
                    }

                    System.out.println("\nSorted by price:\n");
                    Collections.sort(nodes);
                    for (Node node : nodes) {
                        node.show();
                        System.out.println();
                    }

                    System.out.print("Do you want to add a new node? (y/n) ");
                    append = scanner.nextLine();

                    if (append.equalsIgnoreCase("y")) {
                        Node newNode = Node.getNodeFromInput();
                        nodes.add(newNode);
                        Product.writeToFile(nodesPath, newNode);

                        System.out.println("\nSorted by price after adding:\n");
                        Collections.sort(nodes);
                        for (Node node : nodes) {
                            node.show();
                            System.out.println();
                            products.add(node);
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    break;
                case 2:
                    PoemSorting();
                    System.out.println("-------------------------------------------------------------------------");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("There is no such option");
                    break;
            }
        }while(choice!=3);


//        Component newComponent = Component.getComponentFromInput();
//
//        newComponent.show();
//
//        Mechanism newMechanism = Mechanism.getMechanismFromInput();
//        newMechanism.show();
//
//        Node newNode = Node.getNodeFromInput();
//        newNode.show();
    }
}