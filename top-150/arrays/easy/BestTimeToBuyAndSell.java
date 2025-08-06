// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Time Complexity: O(n) - single pass through the array
// Space Complexity: O(1) - only using two variables

class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        // Handle edge cases
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0]; // Track the minimum price seen so far

        // Iterate through prices starting from day 1
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            // Calculate profit if we sell today
            int profitIfSellToday = currentPrice - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profitIfSellToday);

            // Update minimum price (potential buy day)
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }
}
