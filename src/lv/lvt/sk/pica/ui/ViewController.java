package lv.lvt.sk.pica.ui;

import lv.lvt.sk.pica.Order;
import lv.lvt.sk.pica.OrderManager;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.custompizzaview.CustomPizzaView;
import lv.lvt.sk.pica.ui.logview.LogView;
import lv.lvt.sk.pica.ui.mainview.MainView;
import lv.lvt.sk.pica.ui.recieptview.ReceiptView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewController extends JFrame {

    MenuItems menuItems=new MenuItems();;

    MainView mainView = new MainView(this);

    OrderManager orderManager = new OrderManager();

    public ViewController() {
        super("Mamma mia pizzeria");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 750);
        setResizable(false);

        showMainView();
    }

    public void showMainView() {
        System.out.println("ORDERS WHEN MAIN VIEW IS OPENED "+getOrderManager());
        getOrderManager().print();
        setContentPane(mainView);
        setVisible(true);
    }
    public void showCustomPizzaView(double sizeMultiplier) {
        setContentPane(new CustomPizzaView(this, mainView, sizeMultiplier));
        setVisible(true);
    }
    public void showRecieptView(Order order) {
        setContentPane(new ReceiptView(this, order));
        setVisible(true);
    }

    public void showLogView() {
        new LogView(this);
    }

    public MenuItems getMenuItems() {
        return menuItems;
    }

    public ArrayList<Pizza> getPizzas() {
        return menuItems.pizzas;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }
}


















