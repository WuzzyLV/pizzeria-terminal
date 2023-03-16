package lv.lvt.sk.pica.food.sides;

import lv.lvt.sk.pica.food.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Side extends Item {

    double size = 20;

    public Side(String name, double price, String description) {
        super(name, price, description);
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
