package lv.lvt.sk.pica.ui;

import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.mainview.MainView;
import lv.lvt.sk.pica.ui.mainview.MenuItems;

import javax.swing.*;
import java.util.ArrayList;

public class ViewController extends JFrame {

    MenuItems menuItems=new MenuItems();;

    MainView mainView = new MainView(this);

    public ViewController() {
        super("Mamma mia pizzeria");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 750);
        setResizable(false);

        showMainView();
    }

    public void showMainView() {
        setContentPane(mainView);
        setVisible(true);
    }

    public ArrayList<Pizza> getPizzas() {
        return menuItems.pizzas;
    }
}


















