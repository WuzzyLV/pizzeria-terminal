package lv.lvt.sk.pica;

import lv.lvt.sk.pica.food.Item;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    String name;
    String address;
    ArrayList<Item> items;

    public Order(String name, String address, ArrayList<Item> items) {
        this.name = name;
        this.address = (address==null) ? "local" : address ;
        this.items = items;
    }

    public double getTotalPrice(){
        BigDecimal price = BigDecimal.ZERO;
        for (Item item : items) {
            price = price.add(BigDecimal.valueOf(item.getPrice()));
        }
        return price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        String output = "Order for " + name + " to " + address+ "\n";
        for (int i = 0; i < items.size(); i++) {
            Item curr = items.get(i);
            output += curr.getName() +" (" + curr.getDesc() +") - " + curr.getPrice() + " €"+"\n";
        }
        output += "Total: " + getTotalPrice() + " €";
        return output.replaceAll("<html>", "").replaceAll("</html>", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
