package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.ViewController;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JPanel {
    ViewController viewController;

    ArrayList<Item> cartItems = new ArrayList<>();

    JTabbedPane menuPanel;
    MenuItems mitems;
    JPanel pizzaPanel;
    JPanel sides;
    JPanel extras;
    JScrollPane pizzaPanelScroll;
    JScrollPane sidesPanelScroll;
    JScrollPane extrasPanelScroll;

    PricePanel pricePanel;

    public MainView(ViewController controller) {
        this.viewController = controller;
        mitems = new MenuItems();

        setLayout(new WrapLayout());

        fillMenuPanel();
        add(menuPanel);
        //add total price panel add added items panel
        pricePanel = new PricePanel(this);
        add(pricePanel);
    }

    private void fillMenuPanel() {
        menuPanel= new JTabbedPane();
        menuPanel.setPreferredSize(new Dimension(400, 700));
        menuPanel.setBackground(Color.RED);

        pizzaPanel= new PizzaPanel(this, mitems);
        pizzaPanelScroll = new JScrollPane(pizzaPanel);
        pizzaPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        sides= new SidesPanel(this, mitems);
        sidesPanelScroll = new JScrollPane(sides);
        sidesPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        extras = new ExtrasPanel(this, mitems);
        extrasPanelScroll = new JScrollPane(extras);
        extrasPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        menuPanel.addTab("Pizzas", pizzaPanelScroll);
        menuPanel.addTab("Sides", sidesPanelScroll);
        menuPanel.addTab("Extras", extrasPanelScroll);
    }

    public ArrayList<Item> getCart() {
        return cartItems;
    }
    public double getCartPrice() {
        BigDecimal price = BigDecimal.ZERO;
        for (Item item : cartItems) {
            price = price.add(BigDecimal.valueOf(item.getPrice()));
        }
        return price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public String getLog() {
        String log = "";
        for (Item item : cartItems) {
            log += item.getName() +", " + item.getPrice() + " $" + " /n ";
        }
        return log;
    }
    public void addToCart(Item item) {
        cartItems.add(item);
        pricePanel.setPriceLabel(getCartPrice());
        pricePanel.setProductLog(cartItems);
    }

    public void newPizza() {
        viewController.customPizza();
    }
    public void removeFromCart(Item item) {
        cartItems.remove(item);
        pricePanel.setPriceLabel(getCartPrice());
        pricePanel.setProductLog(cartItems);
    }

    public void clearCart() {
        cartItems.clear();
        pricePanel.setPriceLabel(getCartPrice());
        pricePanel.setProductLog(cartItems);
    }

    public void confirmOrder() {
        new ConfirmWindow(this);
    }
}
