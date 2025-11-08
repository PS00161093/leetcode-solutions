// https://leetcode.com/problems/maximum-palindromes-after-operations/description/

class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int len = words.length;
        int[] lengths = new int[len];
        int[] freq = new int[26];
        int count = 0;

        for(int i = 0; i < len; i++) {
            for(char c: words[i].toCharArray()) {
                freq[c - 'a'] = freq[c - 'a'] + 1;
            }
            lengths[i] = words[i].length();
        }

        Arrays.sort(lengths);

        int pairs = 0;
        for(int i: freq) {
            pairs = pairs + (i / 2);
        }

        for(int length: lengths) {
            pairs = pairs - (length / 2);
            if(pairs >= 0) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
