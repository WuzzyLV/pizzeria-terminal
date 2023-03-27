package lv.lvt.sk.pica.ui.logview;

import lv.lvt.sk.pica.ui.ViewController;

import javax.swing.*;

public class LogView {
    public LogView(ViewController controller) {
        String[] options = new String[controller.getOrderManager().getOrders().size()];
        for (int i = 0; i < controller.getOrderManager().getOrders().size(); i++) {
            options[i] = controller.getOrderManager().getOrders().get(i).toTitle();
        }
        JComboBox comboBox = new JComboBox(options);
        int choice = JOptionPane.showOptionDialog(controller, comboBox, "Choose order", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (comboBox.getSelectedIndex() != -1 && choice == JOptionPane.OK_OPTION) {
            controller.showRecieptView(controller.getOrderManager().getOrder(comboBox.getSelectedIndex()));
        }
    }
}
