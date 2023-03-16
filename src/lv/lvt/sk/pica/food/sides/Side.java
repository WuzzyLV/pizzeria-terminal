package lv.lvt.sk.pica.food.sides;

import lv.lvt.sk.pica.food.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Side extends Item {

    double size = 20;

    public Side(String name, double price, String description) {
        super(name, price, description);
    }

    public Side(String name, double price, String description, String imageName) {
        super(name, price, description, imageName);
    }


}
