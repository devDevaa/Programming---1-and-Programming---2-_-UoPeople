import java.util.ArrayList;

public class StockAnalysis {

    // Method to calculate the average stock price
    public static double averagePrice(float[] stockPrices) {
        double sum = 0;
        for (float price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    // Method to find the maximum stock price
    public static float maximunPrice(float[] stockPrices) {
        float maxPrice = stockPrices[0];
        for (float price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to count occurrences of a specific price
    public static int countOccurrences(float[] stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute cumulative sum of stock prices
    public static ArrayList<Float> cumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    public static void main(String[] args) {
        //  10 days of data as float datatype.
        float[] stockPricesArray = {11.5f, 14.5f, 14.8f, 11.7f, 13.4f, 15.7f, 12.2f, 11.2f, 11.6f, 14.4f};
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesArrayList.add(price);
        }
        // Output information
        System.out.println("Average Stock Price is : " + averagePrice(stockPricesArray));
        System.out.println("Maximum Stock Price is : " + maximunPrice(stockPricesArray));
        System.out.println("Occurrences of 11.5 is : " + countOccurrences(stockPricesArray, 11.5f));
        System.out.println("Cumulative Sum is : " + cumulativeSum(stockPricesArrayList));
    }
}
