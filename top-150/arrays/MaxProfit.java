// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150

// Kadane's Algorithm: the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, 
// and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

class Solution {
    public int maxProfit(int[] prices) {
        int currMax = 0;
        int soFarMax = 0;

        for (int i = 1; i < prices.length; i++) {
            currMax = currMax + (prices[i] - prices[i - 1]);
            currMax = Math.max(0, currMax);
            soFarMax = Math.max(soFarMax, currMax);
        }

        return soFarMax;
    }
}
