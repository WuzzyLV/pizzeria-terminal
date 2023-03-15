package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.ViewController;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainView extends JPanel {
    ViewController viewController;

    JTabbedPane menuPanel;
    JPanel pizzaPanel;
    JPanel sides;
    JPanel extras;
    JScrollPane pizzaPanelScroll;

    public MainView(ViewController controller) {
        this.viewController = controller;

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

        pizzaPanel= new JPanel();
        pizzaPanelScroll = new JScrollPane(pizzaPanel);
        fillPizzaPanel();

        sides = new JPanel();
        sides.add(new JLabel("Sides"));

        extras = new JPanel();
        extras.add(new JLabel("Extras"));

        menuPanel.addTab("Pizzas", pizzaPanelScroll);
        menuPanel.addTab("Sides", sides);
        menuPanel.addTab("Extras", extras);
    }

    private void fillPizzaPanel() {
        List<Pizza> pizzas = viewController.getPizzas();

        for (Pizza pizza : pizzas) {
            JPanel currPizzaPanel = new JPanel();
            currPizzaPanel.setLayout(new BoxLayout(currPizzaPanel, BoxLayout.Y_AXIS));
            currPizzaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel helperPanel = new JPanel();
            helperPanel.setLayout(new BoxLayout(helperPanel, BoxLayout.X_AXIS));
            helperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            currPizzaPanel.add(helperPanel);

            JLabel pizzaImg = new JLabel(pizza.getImage());
            pizzaImg.setAlignmentY(Component.CENTER_ALIGNMENT);

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            JLabel pizzaName = new JLabel(pizza.getName() + " ");
            JLabel tops = new JLabel(pizza.getDesc());
            tops.setPreferredSize(new Dimension(175, 40));

            JLabel price = new JLabel(pizza.getPrice() + " $");
            price.setAlignmentY(Component.CENTER_ALIGNMENT);

            //setting fonts
            Font font = new Font(pizzaName.getFont().getFontName(), Font.BOLD, 20);
            pizzaName.setFont(font);
            price.setFont(font);

            infoPanel.add(pizzaName);
            infoPanel.add(tops);

            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(pizzaImg);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(infoPanel);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(price);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

            //currPizzaPanel.setSize(new Dimension(400, pizza.getImage().getIconHeight()));
            currPizzaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JButton size20 = new JButton("20 cm");
            buttonPanel.add(size20);
            JButton size30 = new JButton("30 cm");
            buttonPanel.add(size30);
            JButton size50 = new JButton("50 cm");
            buttonPanel.add(size50);
            currPizzaPanel.add(buttonPanel);
            buttonPanel.setVisible(true);

            currPizzaPanel.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    System.out.println("moved in");
                    //buttonPanel.setVisible(true);
                    buttonPanel.repaint();
                }
                public void mouseExited(MouseEvent evt) {
                    System.out.println("moved out");
                    //buttonPanel.setVisible(false);
                    currPizzaPanel.repaint();
                }
            });

            pizzaPanel.add(currPizzaPanel);
        }

    }





}
