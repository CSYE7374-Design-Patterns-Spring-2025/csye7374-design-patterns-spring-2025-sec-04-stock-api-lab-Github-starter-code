package edu.neu.csye7374;

// Amazon Stock implementation
class AmazonStock extends Stock {
    public AmazonStock() {
        super("AMZN", 178.35, "Amazon.com Inc. Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        // Amazon specific price calculation
        price = price + (bidValue - price) * Math.random();
        metric = Math.pow((bidValue/price - 1), 2) * 100;  // Amazon specific metric
    }

    @Override
    public String getMetric() {
        return String.format("%.2f", metric);
    }
}
