// https://leetcode.com/problems/maximum-palindromes-after-operations/

class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = words[i].length();
        }

        Arrays.sort(arr);

        Map<Character, Integer> count = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }

        int pairs = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pairs += entry.getValue() / 2;
        }

        for (int i = 0; i < n; i++) {
            pairs = pairs - (arr[i] / 2);
            if (pairs < 0) {
                return i;
            }
        }

        return n;

    }
}
