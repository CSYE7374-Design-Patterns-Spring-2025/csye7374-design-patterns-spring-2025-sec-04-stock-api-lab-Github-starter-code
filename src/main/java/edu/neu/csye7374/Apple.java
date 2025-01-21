package edu.neu.csye7374;

public class Apple extends Stock{
    public Apple() {
        super( "Apple", 200,"Apple Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        setPrice(getPrice()+bidValue);
    }

    @Override
    public String getMetric(){
        return "Apple Metric: " + (getPrice() * 0.44);
    }
}
