package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.extras.Cola;
import lv.lvt.sk.pica.food.extras.Extra;
import lv.lvt.sk.pica.food.extras.Fanta;
import lv.lvt.sk.pica.food.extras.Sprite;
import lv.lvt.sk.pica.food.pizzas.MargheritaPizza;
import lv.lvt.sk.pica.food.pizzas.PeperoniPizza;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.food.sides.Fries;
import lv.lvt.sk.pica.food.sides.OnionRings;
import lv.lvt.sk.pica.food.sides.Side;

import java.util.ArrayList;

public class MenuItems {

    public ArrayList<Pizza> pizzas;
    public ArrayList<Side> sides;
    public ArrayList<Extra> extras;

    public MenuItems(){
        ///Pizzas
        pizzas=new ArrayList<>();
        pizzas.add(new PeperoniPizza());
        pizzas.add(new MargheritaPizza());
        //Sides
        sides=new ArrayList<>();
        sides.add(new Fries());
        sides.add(new OnionRings());
        //Extras
        extras=new ArrayList<>();
        extras.add(new Cola());
        extras.add(new Fanta());
        extras.add(new Sprite());

    }
}
