package twoweekschallange.easy;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class WordLength {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.lastIndexOf(" ");
        String w = s.substring(i + 1);

        return w.length();
    }

}
