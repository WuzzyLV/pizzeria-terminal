package lv.lvt.sk.pica.ui.mainview;

import lv.lvt.sk.pica.food.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PricePanel extends JPanel {

    JLabel priceLabel;
    JList productLog;

    public PricePanel(MainView mainView) {
        this.setPreferredSize(new Dimension(200, 700));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //add a blank component to help with spacing
        this.add(Box.createRigidArea(new Dimension(0, 20)));


        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridBagLayout());
        pricePanel.setPreferredSize(new Dimension(200, 100  ));
        pricePanel.setMaximumSize(new Dimension(200, 100  ));
        pricePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        priceLabel = new JLabel(mainView.getCartPrice()+" $");
        priceLabel.setFont(new Font(priceLabel.getFont().getFontName(), Font.BOLD, 40));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        pricePanel.add(priceLabel, new GridBagConstraints());
        this.add(pricePanel);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        productLog = new JList();
        productLog.setAlignmentX(Component.CENTER_ALIGNMENT);
        JScrollPane scrollPane = new JScrollPane(productLog);
        scrollPane.setMaximumSize(new Dimension(200, 450));
        this.add(scrollPane);

        this.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(200, 100));

        JButton orderButton = new JButton("Order");
        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderButton.setPreferredSize(new Dimension(200, 100-5));
        orderButton.addActionListener(e -> {
            if (mainView.getCart().size() > 0) {
                mainView.confirmOrder();
            }
        });
        buttonPanel.add(orderButton);
        this.add(buttonPanel);
    }

    public void setProductLog(ArrayList<Item> log) {
        Object[] logArray = new Object[log.size()];
        for (int i = 0; i < log.size(); i++) {
            logArray[i] = log.get(i).getName()+" "+log.get(i).getPrice()+" $";
        }
        productLog.setListData(logArray);
        productLog.revalidate();
    }

    public void setPriceLabel(double price) {
        priceLabel.setText(price+" $");
        priceLabel.revalidate();
    }
}
