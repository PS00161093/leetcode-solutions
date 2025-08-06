// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Time Complexity: O(n) - single pass through the array
// Space Complexity: O(1) - only using two variables

class BestTimeToBuyAndSell. {
    public int maxProfit(int[] prices) {
        int currMax = 0;
        int soFarMax = 0;

        for(int i = 1; i < prices.length; i++) {
            currMax = currMax + (prices[i] - prices[i - 1]);
            currMax = Math.max(currMax, 0);
            soFarMax = Math.max(currMax, soFarMax);
        }

        return soFarMax;
    }
}
