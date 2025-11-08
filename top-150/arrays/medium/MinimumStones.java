// https://leetcode.com/problems/remove-stones-to-minimize-the-total

class Solution {
    public int minStoneSum(int[] piles, int k) {
        int total = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for(int n: piles) {
            total += n;
            maxHeap.offer(n);
        }

        for(int i = 0; i < k; i++) {
            int maxPiles = maxHeap.poll();
            int removed = maxPiles / 2;
            int remaning = maxPiles - removed;
            total -= removed;
            maxHeap.offer(remaning);
        }

        return total;
    }
}
