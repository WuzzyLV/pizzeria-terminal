package lv.lvt.sk.pica;

import lv.lvt.sk.pica.food.Item;

import java.util.ArrayList;

public class Order {
    String name;
    String address;
    ArrayList<Item> items;

    public Order(String name, String address, ArrayList<Item> items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }
}
