// https://leetcode.com/problems/count-binary-substrings/

class CountryBinary {
  
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int res = 0;
        int prevGroupSize = 0;
        int currGroupSize = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);

            if (c == p) {
                currGroupSize++; // Same character, extend current group
            } else {
                // Different character, start new group
                // Add valid substrings between previous and current group
                res = res + Math.min(currGroupSize, prevGroupSize);

                // reset
                prevGroupSize = currGroupSize;
                currGroupSize = 1;
            }
        }

        res = res + Math.min(currGroupSize, prevGroupSize);

        return res;
    }
}
