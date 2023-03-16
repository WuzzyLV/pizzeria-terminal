package lv.lvt.sk.pica.food;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item implements Cloneable{
    private String name;
    private double price;
    private String desc;
    private ImageIcon image;

    double size = 20;

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

    public void setSize(double size) {
        this.size = size;
        BigDecimal newPrice = BigDecimal.valueOf(getPrice()).multiply(BigDecimal.valueOf(size / 100 + 1));
        setPrice(newPrice.setScale(2, RoundingMode.HALF_UP).doubleValue());
        System.out.println(getPrice());
    }

    public double getSize() {
        return size;
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
