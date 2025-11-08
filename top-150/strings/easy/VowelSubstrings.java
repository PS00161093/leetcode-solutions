// https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

class Solution {
    public int countVowelSubstrings(String word) {
        int len = word.length();
        int ans = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (set.contains(c)) {
                Set<Character> seen = new HashSet<>();
                seen.add(c);
                for (int j = i + 1; j < word.length(); j++) {
                    char nc = word.charAt(j);

                    if (!set.contains(nc))
                        break;

                    if (!seen.contains(nc)) {
                        seen.add(nc);
                    }

                    if (seen.size() == set.size()) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
