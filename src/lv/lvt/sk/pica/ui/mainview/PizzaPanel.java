package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.utils.PriceUtils;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PizzaPanel extends JPanel {

    public PizzaPanel(MainView mainView,MenuItems menuItems) {
        this.setLayout(new WrapLayout());

        for (Pizza pizza : menuItems.pizzas) {
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

            JLabel price = new JLabel(PriceUtils.formatPrice(pizza.getPrice()));
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
            buttonPanel.setVisible(false);

            //enter leave listener for whole panel
            MouseAdapter genericAdapter = new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    if (!buttonPanel.isVisible()) {
                        buttonPanel.setVisible(true);
                    }
                    buttonPanel.repaint();
                }
                public void mouseExited(MouseEvent evt) {
                    if (buttonPanel.isVisible()) {
                        buttonPanel.setVisible(false);
                    }
                    currPizzaPanel.repaint();
                }
            };
            currPizzaPanel.addMouseListener(genericAdapter);
            size20.addMouseListener(genericAdapter);
            //listener for each buttons to set price etc
            size30.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!buttonPanel.isVisible()) {
                        buttonPanel.setVisible(true);
                    }
                    price.setText(PriceUtils.formatPrice(pizza.getPrice() * 1.3));

                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (buttonPanel.isVisible()) {
                        buttonPanel.setVisible(false);
                    }
                    price.setText(PriceUtils.formatPrice(pizza.getPrice()));
                }
            });
            size50.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!buttonPanel.isVisible()) {
                        buttonPanel.setVisible(true);
                    }
                    price.setText(PriceUtils.formatPrice(pizza.getPrice() * 1.5));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (buttonPanel.isVisible()) {
                        buttonPanel.setVisible(false);
                    }
                    price.setText(PriceUtils.formatPrice(pizza.getPrice()));
                }
            });

            size20.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Pizza item = (Pizza) pizza.clone();
                    //dont need to set size because its 20 by default
                    mainView.addToCart(pizza);
                }
            });
            size30.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Pizza item = (Pizza) pizza.clone();
                    item.setSize(30);
                    mainView.addToCart(item);
                }
            });
            size50.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Pizza item = (Pizza) pizza.clone();
                    item.setSize(50);
                    mainView.addToCart(item);
                }
            });

            this.add(currPizzaPanel);
        }
    }
}
