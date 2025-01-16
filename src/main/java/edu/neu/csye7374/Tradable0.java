package edu.neu.csye7374;

public abstract class Tradable0 implements Tradable {
    private double price;
    @Override
    public abstract void setBid(String bid);

    @Override
    public String getMetric() {
        return String.valueOf(0.1*price);
    }
}