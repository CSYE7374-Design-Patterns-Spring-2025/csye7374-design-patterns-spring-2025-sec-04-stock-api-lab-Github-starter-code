package edu.neu.csye7374;

// Tesla Stock implementation
class TeslaStock extends Stock {
    public TeslaStock() {
        super("TSLA", 172.63, "Tesla Inc. Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        // Tesla specific price calculation
        price = Math.sqrt(price * bidValue);
        metric = (bidValue - price) / price * 150;  // Tesla specific metric
    }

    @Override
    public String getMetric() {
        return String.format("%.2f", metric);
    }
}