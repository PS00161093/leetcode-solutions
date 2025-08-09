// https://leetcode.com/problems/remove-invalid-parentheses/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(2^n × n^2) where n is the length of the string
// SPACE COMPLEXITY: O(2^n × n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int minRmv = getMin(s);
        solution(s, minRmv, set);

        return new ArrayList<>(set);
    }

    void solution(String s, int minRmv, Set<String> set) {
        if (minRmv == 0) {
            int minRmvNow = getMin(s);
            if (minRmvNow == 0) {
                if (!set.contains(s)) {
                    set.add(s);
                }
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            solution(left + right, minRmv - 1, set);
        }
    }

    int getMin(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() == 0) {
                    stack.push(c);
                } else if (stack.peek() == ')') {
                    stack.push(c);
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
} 
