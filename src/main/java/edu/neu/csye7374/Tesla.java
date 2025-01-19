package edu.neu.csye7374;

public class Tesla extends Stock {
    public Tesla() {
        super("Tesla", 250.50, "Tesla Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        setPrice(getPrice() + bidValue * 0.8); // Custom bid adjustment for Tesla
    }

    @Override
    public String getMetric() {
        return "Tesla Metric: " + (getPrice() * 0.5); // Custom metric calculation
    }
}
