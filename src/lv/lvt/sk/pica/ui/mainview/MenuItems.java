package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.pizzas.PeperoniPizza;
import lv.lvt.sk.pica.food.pizzas.Pizza;

import java.util.ArrayList;

public class MenuItems {

    public ArrayList<Pizza> pizzas;

    public MenuItems(){
        pizzas=new ArrayList<>();

        pizzas.add(new PeperoniPizza());
    }
}
