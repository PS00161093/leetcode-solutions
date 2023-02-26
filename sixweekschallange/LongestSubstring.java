import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max = Math.max(set.size(), max);
                set.clear();
                s = s.substring(1);
                i = -1;
            } else {
                set.add(c);
                max = Math.max(set.size(), max);
            }
        }

        return max;
    }
  
}
