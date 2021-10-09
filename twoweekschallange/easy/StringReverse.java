package twoweekschallange.easy;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class StringReverse {
    /**
     * O(n)
     *
     * @param s
     */
    private static void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * o(n^2)
     *
     * @param s - char array
     */
    public void reverseString1(char[] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                swap(s, i, j);
            }
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
