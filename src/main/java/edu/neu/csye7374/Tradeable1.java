package edu.neu.csye7374;

// Tradeable1 with default implementation only for getMetric
interface Tradeable1 {
    void setBid(String bid);  // No default implementation

    default String getMetric() {
        return "0.0";
    }
}