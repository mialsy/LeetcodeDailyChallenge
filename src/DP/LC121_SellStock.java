package DP;

public class LC121_SellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];

            if (min > current) {
                min = current;
            } else {
                maxProfit = Math.max(maxProfit, current - min);
            }
        }
        return maxProfit;
    }
}
