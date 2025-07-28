//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Brute force
class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (sb.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                sb.append(s.charAt(j));
                max = Math.max(max, sb.length());
            }
        }

        return max;
    }
}
