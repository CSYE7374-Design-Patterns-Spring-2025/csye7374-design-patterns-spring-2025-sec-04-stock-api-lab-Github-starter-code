package edu.neu.csye7374;

/**
 * 
 * @author Preyash Mehta
 * 
 */

public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //your driver code here
        StockMarket market = StockMarket.getInstance();

        // Add all stock types to the market
        market.addStock(new IBMStock());
        market.addStock(new AppleStock());
        market.addStock(new GoogleStock());
        market.addStock(new MicrosoftStock());
        market.addStock(new TeslaStock());
        market.addStock(new AmazonStock());

        // Show initial state
        market.showAllStocks();

        // Demonstrate trading with 6 different bids for each stock
        String[] stockNames = {"IBM", "AAPL", "GOOGL", "MSFT", "TSLA", "AMZN"};
        double[] bids = {140.00, 135.50, 142.75, 138.90, 145.20, 141.80};

        for (int i = 0; i < 6; i++) {
            System.out.println("\nTrading Round " + (i + 1));
            for (int j = 0; j < stockNames.length; j++) {
                market.tradeStock(stockNames[j], String.valueOf(bids[j] + (i * 5)));
            }
            market.showAllStocks();
        }

        System.out.println("============Main Execution End===================");
   
    }
}



