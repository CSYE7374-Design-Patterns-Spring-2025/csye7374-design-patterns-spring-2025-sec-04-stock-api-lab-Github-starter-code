package edu.neu.csye7374;

public interface Tradeable {
    // Place a bid to buy a stock
    void setBid(String bid);

    // Return performance metric (positive = buy, negative = sell)
    String getMetric();
}