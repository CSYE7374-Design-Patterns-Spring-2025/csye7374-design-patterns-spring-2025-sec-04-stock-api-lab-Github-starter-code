package edu.neu.csye7374;

public class Philips  extends  Stock{
    public Philips() {

        super("Philips", 90.24, "Philips Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        setPrice(getPrice() + bidValue);
    }

    @Override
    public String getMetric() {
        return "Philips Metric: " + (getPrice() * 0.1);
    }
}

