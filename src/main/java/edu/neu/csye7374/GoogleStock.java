package edu.neu.csye7374;

// Google Stock - Uses market sentiment analysis
class GoogleStock extends Stock {
    private double sentiment = 0.0;

    public GoogleStock() {
        super("GOOGL", 142.75, "Alphabet Inc. Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        sentiment = (bidValue > price) ? sentiment + 0.1 : sentiment - 0.1;
        sentiment = Math.max(-1.0, Math.min(1.0, sentiment));

        price = price * (1 + (bidValue - price) / price * (1 + sentiment));
        priceHistory.add(price);

        // Metric based on price momentum and market sentiment
        metric = sentiment * 100;
    }
}
