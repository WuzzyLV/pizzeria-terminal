package lv.lvt.sk.pica.food.pizzas;

import lv.lvt.sk.pica.food.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Pizza {
    String name;
    Double price=0.0;
    ImageIcon image;
    Stack<Item> items = new Stack<>();

    public Pizza(String name) {
        this.name = name;
        image = new ImageIcon("./resources/404.png");
        System.out.println();
    }
    public Pizza(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
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


    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stack<Item> getItems() {
        return items;
    }

    public void setItems(Stack<Item> items) {
        this.items = items;
    }
}
