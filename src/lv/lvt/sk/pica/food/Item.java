package lv.lvt.sk.pica.food;

import java.awt.*;

public class Item {
    private String name;
    private double price;
    private String desc;
    private Image image;

    public Item(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    public Item(String name, double price, String desc, Image image) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public Image getImage() {
        return image;
    }
}
