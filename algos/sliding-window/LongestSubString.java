import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>*
 */
public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        Set<Character> chars = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (chars.contains(c)) {
                Iterator<Character> it = chars.iterator();
                while (it.hasNext()) {
                    if (!it.next().equals(c)) it.remove();
                    else break;
                }
                it.remove();
            }

            chars.add(c);
            if (maxSize < chars.size()) maxSize = chars.size();
        }

        return maxSize;
    }

}
