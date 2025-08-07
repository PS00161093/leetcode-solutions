// leetcode.com/problems/word-break?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// Time Complexity: O(n² × m) where n = string length, m = average word length
// Space Complexity: O(n) for DP array + O(k) for HashSet

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
