package lv.lvt.sk.pica.food.pizzas;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.bases.ThinCrust;
import lv.lvt.sk.pica.food.pizzas.sauces.TomatoSauce;
import lv.lvt.sk.pica.food.pizzas.toppings.CheeseTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.MozzarellaTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.PeperoniTopping;


public class MargheritaPizza extends Pizza{
    public MargheritaPizza() {
        super("Margherita pizza");
        Item[] items = {new ThinCrust(), new TomatoSauce(), new MozzarellaTopping()};
        addTopping(items);


    }
}
