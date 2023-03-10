package lv.lvt.sk.pica.food.pizzas;

import lv.lvt.sk.pica.food.Item;

import java.awt.*;
import java.util.Stack;

public class Pizza {
    String name;
    Double price=0.0;
    Stack<Item> items = new Stack<>();

    public Pizza(String name) {
        this.name = name;
    }

    public void addTopping(Item item) {
        items.push(item);
        price += item.getPrice();
    }
    public void addTopping(Item[] items) {
        for (Item item : items) {
            addTopping(item);
            price += item.getPrice();
        }
    }
    public Stack<Item> getToppings() {
        return items;
    }
}
