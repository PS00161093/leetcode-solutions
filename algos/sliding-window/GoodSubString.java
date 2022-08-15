import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/">...</a>* 
 */
public class GoodSubString {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
    }

    public static int countGoodSubstrings(String s) {
        if (s == null || s.trim().equals("")) return 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();

        for (int i = 0; i <= len - 3; i++) {
            int r = i + 3;
            String ts = s.substring(i, r);
            for (char c : ts.toCharArray()) set.add(c);
            if (set.size() == ts.length()) res = res + 1;
            set.clear();
        }

        return res;
    }
}
