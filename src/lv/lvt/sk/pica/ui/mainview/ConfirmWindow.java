package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.Order;
import lv.lvt.sk.pica.OrderManager;

import javax.swing.*;
import java.awt.*;

public class ConfirmWindow extends JFrame {
    public ConfirmWindow(MainView mainView) {
        super("Confirm order");
        setSize(300, 300);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JLabel nameLab = new JLabel("Name:");
        nameLab.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField nameField = new JTextField(1);
        nameField.setMaximumSize(new Dimension(250,20));
        panel.add(nameLab);
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Adress:");
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField addressField = new JTextField(1);
        addressField.setMaximumSize(new Dimension(250,20));
        addressField.setEnabled(false);
        JCheckBox addressCheckBox = new JCheckBox("Delivery?");
        addressCheckBox.addActionListener(e -> {
            if (addressCheckBox.isSelected()) {
                addressField.setEnabled(true);
            } else {
                addressField.setEnabled(false);
                addressField.setText("");
            }
        });
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(addressCheckBox);

        Button confirmButton = new Button("Confirm");
        confirmButton.addActionListener(e -> {
            OrderManager.addOrder(new Order(nameField.getText(), addressField.getText(), mainView.getCart()));
            dispose();
        });
        panel.add(confirmButton);

    }
}

