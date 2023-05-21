//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
//abstract class Product implements Comparable<Product> {
//    private String name;
//    private double price;
//
//    public Product() {
//        this.name = "Unnamed";
//        this.price = 0;
//    }
//
//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void show() {
//        System.out.println("Product: " + getName());
//        System.out.println("Price: $" + getPrice());
//    }
//
//    @Override
//    public int compareTo(Product other) {
//        // Implement your own comparison logic here
//        // For example, compare based on price
//        return Double.compare(this.price, other.price);
//    }
//}
//
//class Component extends Product {
//    private String material;
//
//    public Component() {
//        super();
//        this.material = "Unknown";
//    }
//
//    public Component(String name, double price, String material) {
//        super(name, price);
//        this.material = material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public String getMaterial() {
//        return material;
//    }
//
//    @Override
//    public void show() {
//        System.out.println("Component:");
//        super.show();
//        System.out.println("Material: " + getMaterial());
//    }
//}
//
//class Node extends Component {
//    private int nodeId;
//
//    public Node() {
//        super();
//        this.nodeId = 0;
//    }
//
//    public Node(String name, double price, String material, int nodeId) {
//        super(name, price, material);
//        this.nodeId = nodeId;
//    }
//
//    public boolean setNodeId(int nodeId) {
//        this.nodeId = nodeId;
//        return true;
//    }
//
//    public int getNodeId() {
//        return nodeId;
//    }
//
//    @Override
//    public void show() {
//        System.out.println("Node:");
//        super.show();
//        System.out.println("Node ID: " + getNodeId());
//    }
//}
//
//class Mechanism extends Component {
//    private String type;
//
//    public Mechanism() {
//        super();
//        this.type = "Unknown";
//    }
//
//    public Mechanism(String name, double price, String material, String type) {
//        super(name, price, material);
//        this.type = type;
//    }
//
//    public boolean setType(String type) {
//        this.type = type;
//        return true;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    @Override
//    public void show() {
//        System.out.println("Mechanism:");
//        super.show();
//        System.out.println("Mechanism Type: " + getType());
//    }
//}
//
//class ProductComparator implements Comparator<Product> {
//    @Override
//    public int compare(Product p1, Product p2) {
//        // Implement your own comparison logic here
//        // For example, compare based on name
//        return p1.getName().compareTo(p2.getName());
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // ArrayLists to store records
//        ArrayList<Component> componentList = new ArrayList<>();
//        ArrayList<Node> nodeList = new ArrayList<>();
//        ArrayList<Mechanism> mechanismList = new ArrayList<>();
//
//        // Read records from files and add them to the respective ArrayLists
//        readFromFile("components.txt", componentList);
//        readFromFile("nodes.txt", nodeList);
//        readFromFile("mechanisms.txt", mechanismList);
//
//        // Print the read data
//        System.out.println("Components:");
//        printRecords(componentList);
//        System.out.println("Nodes:");
//        printRecords(nodeList);
//        System.out.println("Mechanisms:");
//        printRecords(mechanismList);
//
//        // Sort the ArrayLists using Collections.sort() (based on Comparable implementation)
//        Collections.sort(componentList);
//        Collections.sort(nodeList);
//        Collections.sort(mechanismList);
//
//        // Display the sorted data
//        System.out.println("Sorted Components:");
//        printRecords(componentList);
//        System.out.println("Sorted Nodes:");
//        printRecords(nodeList);
//        System.out.println("Sorted Mechanisms:");
//        printRecords(mechanismList);
//
//        // Add one record to each collection entered from the keyboard
//        addRecordFromKeyboard(componentList);
//        addRecordFromKeyboard(nodeList);
//        addRecordFromKeyboard(mechanismList);
//
//        // Sort the ArrayLists again (based on Comparable implementation)
//        Collections.sort(componentList);
//        Collections.sort(nodeList);
//        Collections.sort(mechanismList);
//
//        // Display the sorted data after adding a record
//        System.out.println("Sorted Components after adding a record:");
//        printRecords(componentList);
//        System.out.println("Sorted Nodes after adding a record:");
//        printRecords(nodeList);
//        System.out.println("Sorted Mechanisms after adding a record:");
//        printRecords(mechanismList);
//
//        // Create an ArrayList based on the abstract class
//        ArrayList<Product> productList = new ArrayList<>();
//        productList.addAll(componentList);
//        productList.addAll(nodeList);
//        productList.addAll(mechanismList);
//
//        // Sort the resulting ArrayList using custom Comparator
//        Collections.sort(productList, new ProductComparator());
//
//        // Write the sorted ArrayList to a file
//        writeToFile("sorted_records.txt", productList);
//    }
//
//    private static void readFromFile(String filename, ArrayList<? extends Product> list) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                String name = parts[0];
//                double price = Double.parseDouble(parts[1]);
//
//                // Create a new instance of the appropriate class based on the list type
//                if (list instanceof ArrayList<Component>) {
//                    String material = parts[2];
//                    Component component = new Component(name, price, material);
//                    list.add(component);
//                } else if (list instanceof ArrayList<Node>) {
//                    String material = parts[2];
//                    int nodeId = Integer.parseInt(parts[3]);
//                    Node node = new Node(name, price, material, nodeId);
//                    list.add(node);
//                } else if (list instanceof ArrayList<Mechanism>) {
//                    String material = parts[2];
//                    String type = parts[3];
//                    Mechanism mechanism = new Mechanism(name, price, material, type);
//                    list.add(mechanism);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading from file: " + e.getMessage());
//        }
//    }
//
//    private static void writeToFile(String filename, ArrayList<Product> list) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (Product product : list) {
//                writer.write(product.getName() + "," + product.getPrice());
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }
//
//    private static void printRecords(ArrayList<? extends Product> list) {
//        for (Product product : list) {
//            product.show();
//            System.out.println();
//        }
//    }
//
//    private static void addRecordFromKeyboard(ArrayList<? super Product> list) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter price: ");
//        double price = scanner.nextDouble();
//
//        // Create a new instance of the appropriate class based on the list type
//        if (list instanceof ArrayList<Component>) {
//            scanner.nextLine(); // Consume newline
//            System.out.print("Enter material: ");
//            String material = scanner.nextLine();
//            Component component = new Component(name, price, material);
//            list.add(component);
//        } else if (list instanceof ArrayList<Node>) {
//            System.out.print("Enter material: ");
//            String material = scanner.next();
//            System.out.print("Enter node ID: ");
//            int nodeId = scanner.nextInt();
//            Node node = new Node(name, price, material, nodeId);
//            list.add(node);
//        } else if (list instanceof ArrayList<Mechanism>) {
//            scanner.nextLine(); // Consume newline
//            System.out.print("Enter material: ");
//            String material = scanner.nextLine();
//            System.out.print("Enter mechanism type: ");
//            String type = scanner.nextLine();
//            Mechanism mechanism = new Mechanism(name, price, material, type);
//            list.add(mechanism);
//        }
//    }
//}