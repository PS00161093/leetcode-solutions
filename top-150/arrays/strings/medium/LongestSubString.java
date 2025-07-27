//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
