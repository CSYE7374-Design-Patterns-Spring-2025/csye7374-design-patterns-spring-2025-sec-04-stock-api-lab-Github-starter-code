package edu.neu.csye7374;

// Interface Tradeable0 with default implementations

interface Tradeable0 {
    default void setBid(String bid) {
        System.out.println("Default bid processing: " + bid);
    }

    default String getMetric() {
        return "0.0";
    }
}