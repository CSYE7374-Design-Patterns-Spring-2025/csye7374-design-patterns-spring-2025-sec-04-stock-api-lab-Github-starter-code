package edu.neu.csye7374;

// Microsoft Stock - Uses technical analysis indicators
class MicrosoftStock extends Stock {
    public MicrosoftStock() {
        super("MSFT", 415.25, "Microsoft Corporation Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        double rsi = calculateRSI();
        price = price * (1 + (bidValue - price) / price) * (1 + (rsi - 50) / 100);
        priceHistory.add(price);

        // Metric based on RSI (Relative Strength Index)
        metric = rsi - 50;  // Normalized to make 0 the neutral point
    }

    private double calculateRSI() {
        if (priceHistory.size() < 2) return 50;
        double gains = 0, losses = 0;
        for (int i = 1; i < priceHistory.size(); i++) {
            double change = priceHistory.get(i) - priceHistory.get(i-1);
            if (change > 0) gains += change;
            else losses -= change;
        }
        if (losses == 0) return 100;
        double rs = gains / losses;
        return 100 - (100 / (1 + rs));
    }
}

