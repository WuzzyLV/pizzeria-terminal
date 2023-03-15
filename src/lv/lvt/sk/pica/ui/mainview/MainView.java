package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.ViewController;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainView extends JPanel {
    ViewController viewController;

    JTabbedPane menuPanel;
    MenuItems mitems;
    JPanel pizzaPanel;
    JPanel sides;
    JPanel extras;
    JScrollPane pizzaPanelScroll;

    public MainView(ViewController controller) {
        this.viewController = controller;
        mitems = new MenuItems();

        setLayout(new WrapLayout());

        fillMenuPanel();
        add(menuPanel);

        //add total price panel add added items panel
        JPanel rightPanel= new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 700));
        rightPanel.setBackground(Color.GREEN);
        add(rightPanel);
    }

    private void fillMenuPanel() {
        menuPanel= new JTabbedPane();
        menuPanel.setPreferredSize(new Dimension(400, 700));
        menuPanel.setBackground(Color.RED);

        //todo fix this
        pizzaPanel= new PizzaPanel(mitems);
        pizzaPanelScroll = new JScrollPane(pizzaPanel);

        sides = new JPanel();
        sides.add(new JLabel("Sides"));

        extras = new JPanel();
        extras.add(new JLabel("Extras"));

        menuPanel.addTab("Pizzas", pizzaPanelScroll);
        menuPanel.addTab("Sides", sides);
        menuPanel.addTab("Extras", extras);
    }





}
