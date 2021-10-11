package twoweekschallange.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationExist {

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s1.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        int matchedCnt = 0;

        for (int i = 0; i < s2.length(); ++i) {

            char c = s2.charAt(i);

            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) - 1);
                if (cnt.get(c) == 0) {
                    matchedCnt++;
                }
            }

            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                if (cnt.containsKey(c)) {
                    if (cnt.get(c) == 0) {
                        matchedCnt--;
                    }
                    cnt.put(c, cnt.get(c) + 1);
                }
            }

            if (matchedCnt == cnt.keySet().size()) return true;
        }

        return false;
    }
}
