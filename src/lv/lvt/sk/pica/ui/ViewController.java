package lv.lvt.sk.pica.ui;

import lv.lvt.sk.pica.Order;
import lv.lvt.sk.pica.OrderManager;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.custompizzaview.CustomPizzaView;
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
        String[] options = new String[orderManager.getOrders().size()];
        for (int i = 0; i < orderManager.getOrders().size(); i++) {
            options[i] = orderManager.getOrders().get(i).toTitle();
        }
        JComboBox comboBox = new JComboBox(options);
        JOptionPane.showOptionDialog(this, comboBox, "Choose order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (comboBox.getSelectedIndex() != -1) {
            showRecieptView(orderManager.getOrder(comboBox.getSelectedIndex()));
        }
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


















