package edu.neu.csye7374;

public class Tradable1 implements Tradable {
    private double price;
    @Override
    public void setBid(String bid) {
        price += Double.parseDouble(bid);

    }

    @Override
    public String getMetric() {
        return String.valueOf(0.1*price);
    }
}