// leetcode.com/problems/find-the-original-typed-string-i/

class OriginalString {
  
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ans++;
            }
        }

        return ans;
    }
}
