package com.gabriellazar.data;

import java.util.HashMap;
import java.util.Map;

public class PriceListDataGenerator {

    private static Map<String,Double> priceList = new HashMap<>();

    static {
        priceList.put("Dallas",12.99);
        priceList.put("Austin",11.50);
        priceList.put("San Antonio",10.99);

        priceList.put("Arlington",11.30);
        priceList.put("Fairfax",12.00);
        priceList.put("McLean",11.10);
    }

    public static Map<String, Double> getPriceList() {
        return priceList;
    }

    public static void setPriceList(Map<String, Double> priceList) {
        PriceListDataGenerator.priceList = priceList;
    }
}
