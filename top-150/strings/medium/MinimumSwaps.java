// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int peakMismatches = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                peakMismatches = Math.max(peakMismatches, Math.abs(balance));
            }
        }

        return (peakMismatches + 1) / 2;
    }
}
