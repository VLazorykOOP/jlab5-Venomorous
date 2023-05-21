package Product;

import Validators.InputVal;

import java.util.Scanner;

public class Mechanism extends Component {
    private String type;

    public Mechanism(){
        super();
        this.type = "Unknown";
    }
    public Mechanism(String name, double price, String material, String type) {
        super(name, price, material);
        this.type = type;
    }

    public boolean setType(String type) {
        this.type = type;
        return true;
    }

    public String getType() {
        return type;
    }
    public static Mechanism getMechanismFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the mechanism: ");
        String name = scan.nextLine();
        System.out.println("Enter the price of the mechanism: ");
        double price = InputVal.validateDoubleInput(scan);
        scan.nextLine();
        System.out.println("Enter the material of the mechanism: ");
        String material = scan.nextLine();
        System.out.println("Enter the type of the mechanism: ");
        String type = scan.nextLine();
        return new Mechanism(name, price, material, type);
    }
    @Override
    public void show() {
        System.out.println("Mechanism:");
        super.show();
        System.out.println("Mechanism Type: " + getType());
    }
}
