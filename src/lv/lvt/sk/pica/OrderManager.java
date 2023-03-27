package lv.lvt.sk.pica;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class OrderManager {

    public OrderManager() {
        readOrders();
    }

     ArrayList<Order> orders = new ArrayList<>();

    public  void addOrder(Order order) {
        orders.add(order);

        System.out.println("ORDERS AFTER ADDING NEW");
        print();
        try {
            File file = new File("./logs/"+order.getName()+".txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(order.serialize());
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  Order getOrder(int index) {
        return orders.get(index);
    }
    public  ArrayList<Order> getOrders() {
        return orders;
    }
    public  void removeOrder(Order order) {
        orders.remove(order);
    }

    public  void readOrders() {
        File dir = new File("./logs/");
        File[] directoryListing = dir.listFiles();
        for (File child : directoryListing) {
            orders.add(Order.deserialize(child));
        }
    }

    public  void print() {
        String output = "";
        for (int i = 0; i < orders.size(); i++) {
            output += orders.get(i).toTitle() + "\n";
        }
        System.out.println(output);
    }
}
