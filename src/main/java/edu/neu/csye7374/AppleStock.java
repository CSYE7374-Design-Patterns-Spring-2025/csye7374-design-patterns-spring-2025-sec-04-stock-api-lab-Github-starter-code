package edu.neu.csye7374;

// Apple Stock - Uses volume-weighted price analysis
class AppleStock extends Stock {
    private double volumeWeight = 1.0;

    public AppleStock() {
        super("AAPL", 175.50, "Apple Inc. Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        volumeWeight = Math.min(volumeWeight + 0.2, 2.0);  // Simulating increasing volume
        double priceChange = (bidValue - price) * volumeWeight;
        price = price + priceChange;
        priceHistory.add(price);

        // Metric based on volume-weighted returns
        metric = (priceChange / price) * 100 * volumeWeight;
    }
}