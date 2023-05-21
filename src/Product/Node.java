package Product;

import Validators.InputVal;

import java.util.Scanner;

public class Node extends Component {
    private int nodeId;

    public Node(){
        super();
        this.nodeId = 0;
    }
    public Node(String name, double price, String material, int nodeId) {
        super(name, price, material);
        this.nodeId = nodeId;
    }

    public boolean setNodeId(int nodeId){
        this.nodeId = nodeId;
        return true;
    }

    public int getNodeId() {
        return nodeId;
    }
    public static Node getNodeFromInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the node: ");
        String name = scan.nextLine();
        System.out.println("Enter the price of the node: ");
        double price = InputVal.validateDoubleInput(scan);
        scan.nextLine();
        System.out.println("Enter the material of the node: ");
        String material = scan.nextLine();
        System.out.println("Enter the id of the node: ");
        int NodeId = InputVal.validateIntegerInput(scan);
        return new Node(name, price, material, NodeId);
    }
    @Override
    public void show() {
        System.out.println("Node:");
        super.show();
        System.out.println("Node ID: " + getNodeId());
    }
}
