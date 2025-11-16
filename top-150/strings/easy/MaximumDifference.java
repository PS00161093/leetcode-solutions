// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/

class Solution {

    public int maxDifference(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (int n : map.values()) {
            if (n % 2 == 0) {
                minEven = Math.min(minEven, n);
            } else {
                maxOdd = Math.max(maxOdd, n);
            }
        }

        return maxOdd - minEven;
    }
}
