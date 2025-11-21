// https://leetcode.com/problems/backspace-string-compare/

class Solution {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    private int getNextValidCharIndex(String s, int idx) {
        int backspaces = 0;

        while (idx >= 0) {

            if (s.charAt(idx) == '#') {
                backspaces++;
            } else if (backspaces > 0) {
                backspaces--;
            } else {
                break;
            }

            idx--;
        }

        return idx;
    }
}
