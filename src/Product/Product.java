package Product;

import Validators.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(){
        this.name = "Unnamed";
        this.price = 0;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }

    public static <T> List<T> readFromFile(String fileName, Class<T> TypeOfProduct) {
        List<T> objects = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return objects;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String material = parts[2];
                if (TypeOfProduct.equals(Component.class)) {
                    T object = TypeOfProduct.getConstructor(String.class, double.class, String.class)
                            .newInstance(name, price, material);
                    objects.add(object);
                } else if (TypeOfProduct.equals(Mechanism.class)) {
                    String type = parts[3];
                    T object = TypeOfProduct.getConstructor(String.class, double.class, String.class, String.class)
                            .newInstance(name, price, material, type);
                    objects.add(object);
                } else if (TypeOfProduct.equals(Node.class)) {
                    int NodeId = Integer.parseInt(parts[3]);
                    T object = TypeOfProduct.getConstructor(String.class, double.class, String.class, int.class)
                            .newInstance(name, price, material, NodeId);
                    objects.add(object);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            System.out.println("Error creating object: " + e.getMessage());
        }
        return objects;
    }


    public static void writeToFile(String fileName, Object object) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            if (object instanceof Component) {
                Component component = (Component) object;
                writer.write(component.getName() + "," + component.getPrice() + "," + component.getMaterial());
                writer.newLine();
            } else if (object instanceof Mechanism) {
                Mechanism mechanism = (Mechanism) object;
                writer.write(mechanism.getName() + "," + mechanism.getPrice() + "," + mechanism.getMaterial() + "," + mechanism.getType());
                writer.newLine();
            } else if (object instanceof Node) {
                Node node = (Node) object;
                writer.write(node.getName() + "," + node.getPrice() + "," + node.getMaterial() + "," + node.getNodeId());
                writer.newLine();
            } else {
                System.out.println("Invalid object type.");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    @Override
    public int compareTo(Product other) {
        // Compare the Product objects based on their price
        if (this.price < other.price) {
            return -1;
        } else if (this.price > other.price) {
            return 1;
        } else {
            return 0;
        }
    }
    public void show() {
        System.out.println("Product: " + getName());
        System.out.println("Price: $" + getPrice());
    }
}
