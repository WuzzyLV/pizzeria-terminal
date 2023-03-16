package lv.lvt.sk.pica.utils;

import java.text.DecimalFormat;

public class PriceUtils {

    static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatPrice(double price) {
        return df.format(price)+" €";
    }
}
