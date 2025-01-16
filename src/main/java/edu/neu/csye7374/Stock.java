package edu.neu.csye7374;

import java.util.*;

// Abstract Stock class implementing all three interfaces
abstract class Stock implements Tradeable, Tradeable0, Tradeable1 {
    protected String name;
    protected double price;
    protected String description;
    protected double metric;
    protected List<Double> priceHistory;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.metric = 0.0;
        this.priceHistory = new ArrayList<>();
        priceHistory.add(price);
    }

    // Explicit implementation to resolve interface conflict
    @Override
    public String getMetric() {
        return String.format("%.2f", metric);
    }

    // Declare setBid as abstract to force implementation in subclasses
    @Override
    abstract public void setBid(String bid);

    @Override
    public String toString() {
        return String.format("Stock[name=%s, price=%.2f, description=%s, metric=%.2f]",
                name, price, description, metric);
    }
}