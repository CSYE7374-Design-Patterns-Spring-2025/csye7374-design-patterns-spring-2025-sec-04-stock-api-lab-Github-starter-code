package edu.neu.csye7374;

public abstract class Tradable0 implements Tradable {
    @Override
    public abstract void setBid(String bid);

    @Override
    public String getMetric() {
        return "Default Metric";
    }
}