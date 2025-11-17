// https://leetcode.com/problems/water-bottles/

class Solution {
    
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int max = numBottles;

        while(numBottles >= numExchange) {
            int drank = numBottles/numExchange;
            int remaining = numBottles % numExchange;
            
            max = max + drank;
            numBottles = drank + remaining;
        }

        return max;
    }
}
