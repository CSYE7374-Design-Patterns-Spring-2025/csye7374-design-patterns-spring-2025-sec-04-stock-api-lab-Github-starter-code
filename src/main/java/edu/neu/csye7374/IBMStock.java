package edu.neu.csye7374;

// IBM Stock - Uses price momentum and volatility
class IBMStock extends Stock {
    public IBMStock() {
        super("IBM", 131.15, "IBM Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        double oldPrice = price;
        double momentum = priceHistory.size() > 1 ?
                (priceHistory.get(priceHistory.size()-1) - priceHistory.get(0)) / priceHistory.get(0) : 0;

        price = oldPrice * (1 + (bidValue - oldPrice) / oldPrice) * (1 + momentum);
        priceHistory.add(price);

        // Metric based on price trend and volatility
        metric = momentum * 100 - (calculateVolatility() * 50);
    }

    private double calculateVolatility() {
        if (priceHistory.size() < 2) return 0;
        double sum = 0;
        double mean = priceHistory.stream().mapToDouble(p -> p).average().getAsDouble();
        for (double p : priceHistory) {
            sum += Math.pow(p - mean, 2);
        }
        return Math.sqrt(sum / (priceHistory.size() - 1)) / mean;
    }
}