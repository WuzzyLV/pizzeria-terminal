package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.food.sides.Side;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidesPanel extends JPanel {
    public SidesPanel(MainView mainView,MenuItems menuItems) {
        this.setLayout(new WrapLayout());

        for (Side item : menuItems.sides) {
            JPanel currPanel = new JPanel();
            currPanel.setLayout(new BoxLayout(currPanel, BoxLayout.Y_AXIS));
            currPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel helperPanel = new JPanel();
            helperPanel.setLayout(new BoxLayout(helperPanel, BoxLayout.X_AXIS));
            helperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            currPanel.add(helperPanel);

            JLabel img = new JLabel(item.getImage());
            img.setAlignmentY(Component.CENTER_ALIGNMENT);

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            JLabel name = new JLabel(item.getName() + " ");
            JLabel tops = new JLabel(item.getDesc());
            tops.setPreferredSize(new Dimension(175, 40));
            infoPanel.add(name);
            infoPanel.add(tops);

            JLabel price = new JLabel(item.getPrice() + " $");
            price.setAlignmentY(Component.CENTER_ALIGNMENT);

            //setting fonts
            Font font = new Font(name.getFont().getFontName(), Font.BOLD, 20);
            name.setFont(font);
            price.setFont(font);

            helperPanel.add(Box.createRigidArea(new Dimension(0, 0))); // Add some spacing between the components
            helperPanel.add(img);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(infoPanel);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.add(price);
            helperPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add some spacing between the components
            helperPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

            //currPizzaPanel.setSize(new Dimension(400, pizza.getImage().getIconHeight()));
            currPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JButton size20 = new JButton("M");
            buttonPanel.add(size20);
            JButton size30 = new JButton("L");
            buttonPanel.add(size30);
            JButton size50 = new JButton("XL");
            buttonPanel.add(size50);
            currPanel.add(buttonPanel);
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
                    currPanel.repaint();
                }
            };
            currPanel.addMouseListener(genericAdapter);
            size20.addMouseListener(genericAdapter);
            //listener for each buttons to set price etc
            size30.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!buttonPanel.isVisible()) {
                        buttonPanel.setVisible(true);
                    }
                    price.setText(item.getPrice() * 1.3 + " $");
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (buttonPanel.isVisible()) {
                        buttonPanel.setVisible(false);
                    }
                    price.setText(item.getPrice() + " $");
                }
            });
            size50.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!buttonPanel.isVisible()) {
                        buttonPanel.setVisible(true);
                    }
                    price.setText(item.getPrice() * 1.5 + " $");
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (buttonPanel.isVisible()) {
                        buttonPanel.setVisible(false);
                    }
                    price.setText(item.getPrice() + " $");
                }
            });

            size20.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Side clickedItem = (Side) item.clone();
                    //dont need to set size because its 20 by default
                    mainView.addToCart(clickedItem);
                }
            });
            size30.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Side clickedItem = (Side) item.clone();
                    clickedItem.setSize(30);
                    mainView.addToCart(clickedItem);
                }
            });
            size50.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Side clickedItem = (Side) item.clone();
                    clickedItem.setSize(50);
                    mainView.addToCart(clickedItem);
                }
            });

            this.add(currPanel);

        }
    }
}
