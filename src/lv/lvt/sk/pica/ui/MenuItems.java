package lv.lvt.sk.pica.ui;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.extras.Cola;
import lv.lvt.sk.pica.food.extras.Extra;
import lv.lvt.sk.pica.food.extras.Fanta;
import lv.lvt.sk.pica.food.extras.Sprite;
import lv.lvt.sk.pica.food.pizzas.MargheritaPizza;
import lv.lvt.sk.pica.food.pizzas.PeperoniPizza;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.food.pizzas.bases.ThickCrust;
import lv.lvt.sk.pica.food.pizzas.bases.ThinCrust;
import lv.lvt.sk.pica.food.pizzas.sauces.CurrySauce;
import lv.lvt.sk.pica.food.pizzas.sauces.TomatoSauce;
import lv.lvt.sk.pica.food.pizzas.toppings.ChampignonTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.CheeseTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.MozzarellaTopping;
import lv.lvt.sk.pica.food.pizzas.toppings.RedOnionTopping;
import lv.lvt.sk.pica.food.sides.Fries;
import lv.lvt.sk.pica.food.sides.IceCream;
import lv.lvt.sk.pica.food.sides.Side;

import java.util.ArrayList;

public class MenuItems {

    public ArrayList<Pizza> pizzas;
    public ArrayList<Side> sides;
    public ArrayList<Extra> extras;

    public ArrayList<Item> toppings;

    public MenuItems(){
        ///Pizzas
        pizzas=new ArrayList<>();
        pizzas.add(new PeperoniPizza());
        pizzas.add(new MargheritaPizza());
        //Sides
        sides=new ArrayList<>();
        sides.add(new Fries());
        sides.add(new IceCream());
        //Extras
        extras=new ArrayList<>();
        extras.add(new Cola());
        extras.add(new Fanta());
        extras.add(new Sprite());

        //Toppings
        toppings=new ArrayList<>();
        toppings.add(new ThickCrust());
        toppings.add(new ThinCrust());
        toppings.add(new CurrySauce());
        toppings.add(new TomatoSauce());

        toppings.add(new ChampignonTopping());
        toppings.add(new CheeseTopping());
        toppings.add(new MozzarellaTopping());
        toppings.add(new RedOnionTopping());


    }
}
