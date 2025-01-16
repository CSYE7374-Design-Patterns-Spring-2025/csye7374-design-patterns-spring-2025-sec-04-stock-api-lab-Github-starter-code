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
        Stock msftStock = new MSFT();

        market.addStock(msftStock);

        String[] bids = {"5.0", "-3.0", "2.0", "4.0", "-1.0", "3.0"};
        for (String bid : bids) {
            market.tradeStock("MSFT", bid);
            market.showAllStocks();
        }



        System.out.println("============Main Execution End===================");
   
    }
}



