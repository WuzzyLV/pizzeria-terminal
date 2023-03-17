package lv.lvt.sk.pica;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class OrderManager {

    static ArrayList<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);

        try {
            File file = new File("./logs/"+order.getName()+".txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(order.toString());
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeOrder(Order order) {
        orders.remove(order);
    }
}
