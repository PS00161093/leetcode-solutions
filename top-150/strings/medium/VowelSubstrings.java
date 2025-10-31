// https://leetcode.com/problems/count-vowel-substrings-of-a-string/

class Solution {
    public int countVowelSubstrings(String word) {
        return atMost(word, 5) - atMost(word, 4);
    }

    private int atMost(String s, int k) {
        int len = s.length();
        int ans = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for (int right = 0; right < len; right++) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                left = right + 1;
                map.clear();
                continue;
            }

            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);

                if (map.get(lc) == 0) {
                    map.remove(lc);
                }
                left++;
            }

            ans = ans + (right - left + 1);
        }

        return ans;
    }
}
