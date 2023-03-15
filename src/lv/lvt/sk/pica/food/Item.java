package lv.lvt.sk.pica.food;

import javax.swing.*;
import java.awt.*;

public class Item {
    private String name;
    private double price;
    private String desc;
    private ImageIcon image;

    public Item(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    public Item(String name, double price, String desc, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void addToPrice(double price) {
        this.price += price;
    }
}
