package lv.lvt.sk.pica.ui.custompizzaview;

import lv.lvt.sk.pica.food.Item;
import lv.lvt.sk.pica.food.pizzas.Pizza;
import lv.lvt.sk.pica.ui.ViewController;
import lv.lvt.sk.pica.ui.mainview.MainView;
import lv.lvt.sk.pica.utils.PriceUtils;
import lv.lvt.sk.pica.utils.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CustomPizzaView extends JPanel {
    ViewController viewController;

    JComboBox toppings;
    JButton add;
    JList<String> toppingsList;
    DefaultListModel<String> toppingsModel;

    JButton cancel;
    JButton confirm;

    ArrayList<Item> addedItems;
    ArrayList<Item> allToppings;

    double sizeMultiplier;

    public CustomPizzaView(ViewController viewController, MainView mainView, double sizeMultiplier) {
        this.viewController=viewController;
        this.sizeMultiplier=sizeMultiplier;
        addedItems=new ArrayList<>();
        allToppings=viewController.getMenuItems().toppings;

        this.setLayout(new BorderLayout());

        toppings= new JComboBox();
        Font font=new Font(toppings.getFont().getFontName(), Font.PLAIN, 20);
        toppings.setFont(font);

        toppings.setMaximumSize(new Dimension(190, 30));
        toppings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        for (Item topping : viewController.getMenuItems().toppings) {
            toppings.addItem(topping.getName() + " - " + PriceUtils.formatPrice(topping.getPrice()*sizeMultiplier));
        }
        add= new JButton("Add");
        add.setFont(font);
        add.addActionListener(e -> {
            Item selected =allToppings.get(toppings.getSelectedIndex());
            addedItems.add(selected);
            toppingsModel.insertElementAt(selected.getName() + " - " + PriceUtils.formatPrice(selected.getPrice()*sizeMultiplier), 0);
            confirm.setEnabled(true);
            updatePrice();
        });
        JPanel addPanel = new JPanel();
        addPanel.add(toppings);
        addPanel.add(add);

        toppingsModel=new DefaultListModel<>();
        toppingsList = new JList<>(toppingsModel);
        toppingsList.setFont(font);

        cancel= new JButton("Cancel");
        cancel.setFont(font);
        cancel.addActionListener(e -> {
            viewController.showMainView();
            clearLists();
        });
        confirm= new JButton("Confirm - " + PriceUtils.formatPrice(0));
        confirm.setFont(font);
        confirm.setEnabled(false);
        confirm.addActionListener(e -> {
            Pizza pizza = new Pizza("Custom pizza");
            for (Item item : addedItems) {
                pizza.addTopping(item);
            }
            pizza.setSize((sizeMultiplier-1)*100);
            mainView.addToCart(pizza);
            viewController.showMainView();
            clearLists();
        });
        JPanel controls = new JPanel();
        controls.add(cancel);
        controls.add(confirm);

        add(addPanel, BorderLayout.PAGE_START);
        add(toppingsList, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);

    }

    private void clearLists(){
        addedItems.clear();
        toppingsModel.clear();
    }

    private void updatePrice(){
        System.out.println("Updating price");
        BigDecimal price=BigDecimal.ZERO;
        for (Item item : addedItems) {
            price=price.add(BigDecimal.valueOf(item.getPrice()));
        }
        confirm.setText("Confirm - " + PriceUtils.formatPrice(price.doubleValue()*sizeMultiplier));
        confirm.revalidate();
    }
}


