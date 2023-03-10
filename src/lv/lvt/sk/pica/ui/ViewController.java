package lv.lvt.sk.pica.ui;

import lv.lvt.sk.pica.ui.mainview.MainView;

import javax.swing.*;

public class ViewController extends JFrame {

    MainView mainView = new MainView();

    public ViewController() {
        super("Mamma mia pizzeria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 750);

        showMainView();
    }

    public void showMainView() {
        setContentPane(mainView);
        setVisible(true);
    }
}


















