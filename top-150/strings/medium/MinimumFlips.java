// https://leetcode.com/problems/flip-string-to-monotone-increasing

//   At each position, we have two choices when we encounter a '0':
//   1. Flip this '0' to '1' (cost: current flips + 1)
//   2. Flip all previous '1's to '0' (cost: count of previous 1s)

class Solution {
    public int minFlipsMonoIncr(String s) {
        int countOnes = 0;
        int minFlips = 0;

        for(char c: s.toCharArray()) {
            if(c == '1') {
                countOnes++;
            } else {
                minFlips = Math.min(minFlips + 1, countOnes);
            }
        }

        return minFlips;
    }
}
