package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.Order;
import lv.lvt.sk.pica.OrderManager;
import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.Delivery;
import lv.lvt.sk.pica.utils.PriceUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfirmWindow extends JFrame {
    public ConfirmWindow(MainView mainView) {
        super("Confirm order");
        setSize(300, 300);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JLabel nameLab = new JLabel("Name:");
        //nameLab.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField nameField = new JTextField(1);
        nameField.setMaximumSize(new Dimension(250,20));
        panel.add(nameLab);
        panel.add(nameField);

        Button confirmButton = new Button(PriceUtils.formatPrice(mainView.getCartPrice()));

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField addressField = new JTextField(1);
        addressField.setMaximumSize(new Dimension(250,20));
        addressField.setEnabled(false);
        JCheckBox addressCheckBox = new JCheckBox("Delivery?");
        if(mainView.hasDelivery()) {
            addressCheckBox.setSelected(true);
        }
        addressCheckBox.addActionListener(e -> {
            if (addressCheckBox.isSelected()) {
                addressField.setEnabled(true);
                mainView.addDelivery();
            } else {
                addressField.setEnabled(false);
                addressField.setText("");
                mainView.removeDelivery();
            }
            confirmButton.setLabel(PriceUtils.formatPrice(mainView.getCartPrice()));
        });
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(addressCheckBox);

        confirmButton.setBackground(new Color(131, 171, 131));
        confirmButton.setFont(new Font(nameLab.getFont().getFontName(), Font.BOLD, 40));
        confirmButton.addActionListener(e -> {
            String address = (addressField.getText().equals("")) ? null : addressField.getText();
            Order order = new Order(nameField.getText(), address, (ArrayList<Item>) mainView.getCart().clone());
            mainView.viewController.getOrderManager().addOrder(order);

            mainView.viewController.showRecieptView(order);
            mainView.clearCart();
            dispose();
        });
        panel.add(confirmButton);

    }
}

