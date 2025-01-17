package edu.neu.csye7374;

public class Adobe extends Stock {

    public Adobe() {
        super("Adobe", 101, "Adobe Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        setPrice(getPrice() + bidValue);
    }

    @Override
    public String getMetric() {
        return "Adobe Metric: " + (getPrice() * 0.7);
    }
}