package lv.lvt.sk.pica;

import java.util.ArrayList;

public class OrderManager {

    static ArrayList<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static void removeOrder(Order order) {
        orders.remove(order);
    }
}
