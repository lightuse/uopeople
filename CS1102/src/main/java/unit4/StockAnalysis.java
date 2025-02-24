package unit4;

import java.util.ArrayList;
import java.util.Random;

/**
 * Stock Analysis Utility Class
 * 
 * This class provides utility methods for analyzing stock prices.
 */
public class StockAnalysis {
    /** 
     * Calculate the average stock price (array version)
     * 
     * @param prices array of stock prices
     * 
     * @return average stock price
     */ 
    public static float calculateAveragePrice(float[] prices) {
        if (prices.length == 0) {
            return 0; 
        }
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    /**
     * Calculate the average stock price (ArrayList version)
     * 
     * @param prices ArrayList of stock prices
     * 
     * @return average stock price
     */
    public static float calculateAveragePrice(ArrayList<Float> prices) {
        if (prices.isEmpty()) {
            return 0;
        }
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }
 
    /**
     * Find the maximum stock price (array version)
     * 
     * @param prices array of stock prices
     * 
     * @return maximum stock price
     */
    public static float findMaximumPrice(float[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        float max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) { 
                max = prices[i];
            }
        }
        return max;
    }
 
    /**
     * Find the maximum stock price (ArrayList version)
     * 
     * @param prices ArrayList of stock prices
     * 
     * @return maximum stock price
     */
    public static float findMaximumPrice(ArrayList<Float> prices) {
        if (prices.isEmpty()) {
            return 0;
        }
        float max = prices.get(0);
        for (int i = 1; i < prices.size(); i++) { 
            if (prices.get(i) > max) {
                max = prices.get(i);
            }
        }
        return max;
    }
 
    /**
     * Count the number of occurrences of a target price in the stock prices
     * 
     * @param prices array of stock prices
     * @param targetPrice target price to count
     * 
     * @return number of occurrences of target price
     */
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }
 
    /** 
     * Count the number of occurrences of a target price in the stock prices
     * 
     * @param prices ArrayList of stock prices
     * 
     * @return number of occurrences of target price
     */ 
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    /**
     * Main method to test StockAnalysis methods
     * 
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Generate random stock prices
        Random random = new Random();
        float[] stockPrices = new float[10];
        for (int i = 0; i < stockPrices.length; i++) {
            // Random prices between 100.0 and 250.0, formatted to one decimal place
            stockPrices[i] = 100.0f + Math.round(random.nextFloat() * 1500.0f) / 10.0f; 
        }
        ArrayList<Float> stockPricesList = new ArrayList<>();
        for (float price : stockPrices) {
            stockPricesList.add(price);
        }
        // Display the generated random stock prices 
        System.out.println("Generated Random Stock Prices:");
        for (float price : stockPrices) {
            System.out.println(price);
        }
        System.out.println("Average Price (array): " + calculateAveragePrice(stockPrices));
        System.out.println("Average Price (ArrayList): " + calculateAveragePrice(stockPricesList));
        System.out.println("Maximum Price (array): " + findMaximumPrice(stockPrices));
        System.out.println("Maximum Price (ArrayList): " + findMaximumPrice(stockPricesList));
        System.out.println("Occurrences of price 200.0: " + countOccurrences(stockPrices, 200.0f));
        System.out.println("Cumulative Sum: " + computeCumulativeSum(stockPricesList));
    }
}