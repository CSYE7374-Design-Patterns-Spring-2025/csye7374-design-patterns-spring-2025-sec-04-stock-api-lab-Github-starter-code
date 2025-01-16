package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

// Lazy Singleton StockMarket class
class StockMarket {
    private static StockMarket instance;  // Single instance of StockMarket
    private List<Stock> stocks;  // List to store all stocks

    // Private constructor to prevent direct instantiation
    private StockMarket() {
        stocks = new ArrayList<>();
    }

    // Public method to get the singleton instance
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

    // Method to add a stock to the market
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // Method to remove a stock from the market
    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    // Method to trade a stock (process a bid)
    public void tradeStock(String stockName, String bid) {
        for (Stock stock : stocks) {
            if (stock.name.equals(stockName)) {
                double oldPrice = stock.price;
                String oldMetric = stock.getMetric();
                stock.setBid(bid);
                System.out.printf("%s: Price changed from %.2f to %.2f, Metric changed from %s to %s%n",
                        stock.name, oldPrice, stock.price, oldMetric, stock.getMetric());
                return;
            }
        }
        System.out.println("Stock not found: " + stockName);
    }

    // Method to display all stocks
    public void showAllStocks() {
        System.out.println("\nCurrent Stock Market Status:");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }
}
