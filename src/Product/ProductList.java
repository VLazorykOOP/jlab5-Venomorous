import Product.*;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class ProductList<T extends Product> extends ArrayList<T> {
    public abstract void readFromFile(String fileName);

    public void sortAndWriteToFile(String fileName) {
        Collections.sort(this, new ProductComparator());
        writeToFile(fileName);
    }

    private void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T product : this) {
                writer.write(product.getName() + "," + product.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class ComponentList extends ProductList<Component> {
    @Override
    public void readFromFile(String fileName) {
        List<Component> objects = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File " +fileName + " not found.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String material = parts[2];
                Component component = new Component(name, price, material);
                objects.add(component);
                line = reader.readLine();
            }
            this.addAll(objects);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class MechanismList extends ProductList<Mechanism> {
    @Override
    public void readFromFile(String fileName) {
        List<Mechanism> objects = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File " +fileName + " not found.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String material = parts[2];
                String type = parts[3];
                Mechanism mechanism = new Mechanism(name, price, material, type);
                objects.add(mechanism);
                line = reader.readLine();
            }
            this.addAll(objects);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class NodeList extends ProductList<Node> {
    @Override
    public void readFromFile(String fileName) {
        List<Node> objects = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File " +fileName + " not found.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String material = parts[2];
                int nodeId = Integer.parseInt(parts[3]);
                Node node = new Node(name, price, material, nodeId);
                objects.add(node);
                line = reader.readLine();
            }
            this.addAll(objects);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class ProductTester {
    public static void main(String[] args) {
        ComponentList componentList = new ComponentList();
        componentList.readFromFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\components.txt");
        componentList.sortAndWriteToFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\sorted_components.txt");

        MechanismList mechanismList = new MechanismList();
        mechanismList.readFromFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\mechanisms.txt");
        mechanismList.sortAndWriteToFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\sorted_mechanisms.txt");

        NodeList nodeList = new NodeList();
        nodeList.readFromFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\nodes.txt");
        nodeList.sortAndWriteToFile("C:\\Users\\gurki\\IdeaProjects\\jlab5-Venomorous\\src\\Product\\sorted_nodes.txt");
    }
}
