package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private static StockMarket instance;
    private final Map<String, Stock> stocks;

    private StockMarket() {
        stocks = new HashMap<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getName(), stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void showAllStocks() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }

    public void tradeStock(Stock stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock);
    }

    public void initializeBiding(Stock stock, String[] bids) {
        for (String bid : bids) {
            tradeStock(stock, bid);
        }
    }

    public static void demo() {
        StockMarket stockMarket = StockMarket.getInstance();

        System.out.println("======= MSFT Stock Bid Start ======= ");
        Stock msftStock = new MSFT();
        stockMarket.addStock(msftStock);
        stockMarket.initializeBiding(msftStock, new String[]{"90", "100", "90", "80", "150", "155"});
        System.out.println("\n");

        System.out.println("======= Adobe Stock Bid Start ======= ");
        Stock adobeStock = new Adobe();
        stockMarket.addStock(adobeStock);
        stockMarket.initializeBiding(adobeStock, new String[]{"260", "280", "230", "275", "275", "290"});
        System.out.println("\n");

        System.out.println("======= All Stock Information ======= ");
        stockMarket.showAllStocks();
        System.out.println("\n");
    }
}