//https://leetcode.com/problems/valid-palindrome-ii/description/

class ValidPalindromeV2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                return checkAfterRemoval(s, left + 1, right) || checkAfterRemoval(s, left, right - 1);
            } 
            left++;
            right--;
        }

        return true;
    }

    public boolean checkAfterRemoval(String s, int i, int j) {
        int left = i;
        int right = j;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                return false;
            } 
            left++;
            right--;
        }

        return true;
    }
}
