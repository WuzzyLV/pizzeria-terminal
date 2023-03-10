package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    public MainView() {
        setLayout(new WrapLayout());

        JTabbedPane leftPanel= new JTabbedPane();
        leftPanel.setPreferredSize(new Dimension(400, 700));
        leftPanel.setBackground(Color.RED);

        JPanel pizzas = new JPanel();
        pizzas.add(new JLabel("Pizzas"));

        JPanel sides = new JPanel();
        sides.add(new JLabel("Sides"));

        JPanel extras = new JPanel();
        extras.add(new JLabel("Extras"));

        leftPanel.addTab("Pizzas", pizzas);
        leftPanel.addTab("Sides", sides);
        leftPanel.addTab("Extras", extras);


        JPanel rightPanel= new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 700));
        rightPanel.setBackground(Color.GREEN);

        add(leftPanel);
        add(rightPanel);






    }




}
