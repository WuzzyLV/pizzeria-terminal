package lv.lvt.sk.pica.food.pizzas;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.bases.ThinCrust;
import lv.lvt.sk.pica.food.pizzas.sauces.TomatoSauce;
import lv.lvt.sk.pica.food.pizzas.toppings.CheeseTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.PeperoniTopping;

import javax.swing.*;
import java.io.File;
import java.net.URL;

public class PeperoniPizza extends Pizza {
    public PeperoniPizza() {
        super("Peperoni pizza");
        Item[] items = {new ThinCrust(), new TomatoSauce(), new CheeseTopping(), new PeperoniTopping()};
        addTopping(items);

        this.setImage(new ImageIcon("./out/production/Allis_Pica/lv/lvt/sk/pica/resources/missing.png"));
    }
}
