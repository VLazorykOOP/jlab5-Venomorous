package Product;

import Validators.InputVal;

import java.util.Scanner;
public class Component extends Product {

    private String material;

    public Component(){
        super();
        this.material = "Unknown";
    }
    public Component(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
    public static Component getComponentFromInput() {
        Scanner scan = new Scanner(System.in);
    System.out.println("Enter the name of the component: ");
    String name = scan.nextLine();
        System.out.println("Enter the price of the component: ");
    double price = InputVal.validateDoubleInput(scan);
        scan.nextLine();
        System.out.println("Enter the material of the component: ");
    String material = scan.nextLine();
        return new Component(name, price, material);
    }
    @Override
    public void show() {
//        System.out.println("Component:");
        super.show();
        System.out.println("Material: " + getMaterial());
    }
}
