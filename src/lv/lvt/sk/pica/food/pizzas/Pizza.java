package lv.lvt.sk.pica.food.pizzas;

import lv.lvt.sk.pica.food.Item;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Pizza extends Item{
    Stack<Item> items = new Stack<>();

    double size=20;

    public Pizza(String name) {
        super(name, 0.0, "", "pizzabox");
    }
    public Pizza(String name, String image) {
        super(name, 0.0, "", image);
    }
    public void addTopping(Item item) {
        items.push(item);
        super.addToPrice(item.getPrice());
        super.setDesc(createDesc());
    }
    public void addTopping(Item[] items) {
        for (Item item : items) {
            addTopping(item);
        }
        super.setDesc(createDesc());
    }
    public Stack<Item> getToppings() {
        return items;
    }

    public Stack<Item> getItems() {
        return items;
    }

    public void setItems(Stack<Item> items) {
        this.items = items;
    }

    private String createDesc() {
        String itemsString = "<html>";
        for (Item item : items) {
            itemsString += item.getName() + ", ";
        }
        itemsString=itemsString.substring(0, itemsString.length() - 2);
        return itemsString+"</html>";
    }
}
