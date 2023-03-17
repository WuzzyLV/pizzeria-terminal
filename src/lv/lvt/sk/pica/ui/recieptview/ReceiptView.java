package lv.lvt.sk.pica.ui.recieptview;

import lv.lvt.sk.pica.Order;
import lv.lvt.sk.pica.ui.ViewController;

import javax.swing.*;
import java.awt.*;

public class ReceiptView extends JPanel {
    ViewController viewController;

    public ReceiptView(ViewController viewController, Order order) {
        this.viewController = viewController;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JEditorPane  receipt = new JEditorPane();
        receipt.setFont(new Font(receipt.getFont().getFontName(), Font.PLAIN, 20));
        receipt.setEditable(false);
        receipt.setText(order.toString());
        add(receipt);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> viewController.showMainView());
        add(continueButton);

    }
}
