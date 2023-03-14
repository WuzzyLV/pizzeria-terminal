package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.ViewController;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainView extends JPanel {
    ViewController viewController;

    JTabbedPane menuPanel;
    JPanel pizzaPanel;
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

        JPanel sides = new JPanel();
        sides.add(new JLabel("Sides"));

        JPanel extras = new JPanel();
        extras.add(new JLabel("Extras"));

        menuPanel.addTab("Pizzas", pizzaPanelScroll);
        menuPanel.addTab("Sides", sides);
        menuPanel.addTab("Extras", extras);
    }

    private void fillPizzaPanel() {
        List<Pizza> pizzas = viewController.getPizzas();
        if (pizzas==null){
            return;
        }


        for (int i = 0; i < pizzas.size(); i++) {
            Pizza pizza = pizzas.get(i);
            JPanel currPizzaPanel = new JPanel();
            currPizzaPanel.setLayout(new BoxLayout(currPizzaPanel, BoxLayout.X_AXIS));
            JPanel helperPanel = new JPanel();
            //helperPanel.setLayout(new BoxLayout(helperPanel, BoxLayout.X_AXIS));
            helperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            currPizzaPanel.add(helperPanel);

            JLabel pizzaImg = new JLabel(pizza.getImage());
            pizzaImg.setAlignmentY(Component.CENTER_ALIGNMENT);

            JLabel pizzaName = new JLabel(pizza.getName() + " ");
            pizzaName.setAlignmentY(Component.CENTER_ALIGNMENT);

            JLabel price = new JLabel(pizza.getPrice().toString() + " $");
            price.setAlignmentY(Component.CENTER_ALIGNMENT);

            //setting fonts
            Font font = new Font( pizzaName.getFont().getFontName(), Font.BOLD, 20);
            pizzaName.setFont(font);
            price.setFont(font);

            helperPanel.add(pizzaImg);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(pizzaName);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(price);

            helperPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

            //TODO make the height scaled based on image or center it properly
            currPizzaPanel.setPreferredSize(new Dimension(380, 100));
            currPizzaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            pizzaPanel.add(currPizzaPanel);
        }

    }





}
