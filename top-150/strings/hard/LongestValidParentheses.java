// https://leetcode.com/problems/longest-valid-parentheses?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// Time: O(n), Space: O(n)

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] valid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                //push opening bracket index
                stack.push(i);
            } else if (c == ')') {
                // find closing bracket
                if (!stack.isEmpty()) {
                    int openIndex = stack.pop();
                    valid[openIndex] = true;
                    valid[i] = true;
                }
            }
        }

        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
