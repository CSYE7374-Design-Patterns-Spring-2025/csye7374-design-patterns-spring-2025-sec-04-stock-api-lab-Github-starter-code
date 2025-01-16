package edu.neu.csye7374;

public class MSFT extends Stock {

    public MSFT() {
        super("MSFT", 131.15, "MSFT Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        setPrice(getPrice() + bidValue);
    }

    @Override
    public String getMetric() {
        return "MSFT Metric: " + (getPrice() * 0.1);
    }
}