package lv.lvt.sk.pica.food.extras;

import lv.lvt.sk.pica.food.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Extra extends Item {

    double size = 20;

    public Extra(String name, double price, String desc) {
        super(name, price, desc);
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

}
