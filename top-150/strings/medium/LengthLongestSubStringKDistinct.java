//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/

class LengthLongestSubStringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }            

      //two-pointer, sliding window
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // since, we can't have more than k chars, remove from left & expand the window
            while (map.size() > k) {
                char toDelete = s.charAt(left);
                if (map.get(toDelete) == 1) {
                    map.remove(toDelete);
                } else {
                    map.put(toDelete, map.get(toDelete) - 1);
                }
                left++; // moving the window
            }

            result = Math.max(right - left + 1, result); // size of the window = (right - left + 1)
            right++; // moving the window
        }

        return result;
    }
}
