package lv.lvt.sk.pica.food;

import javax.swing.*;
import java.awt.*;

public class Item implements Cloneable{
    private String name;
    private double price;
    private String desc;
    private ImageIcon image;

    public Item(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        image=new ImageIcon("./out/production/Allis_Pica/lv/lvt/sk/pica/resources/missing.png");
    }
    public Item(String name, double price, String desc, String imageName) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        image=new ImageIcon("./out/production/Allis_Pica/lv/lvt/sk/pica/resources/"+imageName+".png");
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

    @Override
    public Item clone() {
        try {
            Item clone = (Item) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
