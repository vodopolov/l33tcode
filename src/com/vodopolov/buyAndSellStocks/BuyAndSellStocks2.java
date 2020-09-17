package com.vodopolov.buyAndSellStocks;

/**
 * Created by Anton on 08.03.2020.
 */
public class BuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        int growSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) growSum += prices[i] - prices[i - 1];
        }
        return growSum;
    }
}
