package lv.lvt.sk.pica;

import lv.lvt.sk.pica.food.Item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public String serialize(){
        String output = name + ";" + address + ";" + items.size() + ";";
        for (int i = 0; i < items.size(); i++) {
            Item curr = items.get(i);
            String desc = curr.getDesc().replaceAll("<html>", "").replaceAll("</html>", "");
            output += curr.getName() + ";" + curr.getPrice() + ";" + desc + ";";
        }
        output += getTotalPrice();
        return output;
    }
    public static Order deserialize(File child) {
        String inputString = "";
        try {
            FileReader fr = new FileReader(child);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                inputString += line;
            }
            br.close();
            fr.close();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        String[] data = inputString.split(";");
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 3; i < data.length-1; i+=3) {
            items.add(new Item(data[i], Double.parseDouble(data[i+1]), data[i+2]));
        }
        return new Order(data[0], data[1], items);
    }
    public String toTitle() {
        return name + " - " + getTotalPrice() + " €";
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
