package twoweekschallange.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestUniqueSubString {

    /*
    Idea is to,
    1. Keep a hashmap which stores the characters in string as keys and their positions as values.
    2. Keep two pointers which define the max substring.
    3. Move the right pointer to scan through the string , and meanwhile update the hashmap.
    4. If the character is already in the hashmap, then move the left pointer to the right of the same character last found.

    Note that the two pointers can only move forward.
    */
    public int lengthOfLongestSubstring(String s) {

        int length = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(map.get(c), j);
            }
            res = Math.max(res, i - j + 1);
            map.put(c, i + 1);
        }

        return res;
    }



    /*
    Idea is to,
    1. Keep a linkedHashSet to stores keys + to maintain insertion order
    2. Iterate through string.
    3. If set does not contains the char, add it to set, else, remove the char from the map till the matching char from front
    */
    public int lengthOfLongestSubstring1(String s) {
        int maxSize = 0;
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) removeTillRepeatingCharacter(set, c);
            else set.add(c);
            maxSize = Math.max(set.size(), maxSize);
        }
        return maxSize;
    }

    private void removeTillRepeatingCharacter(Set<Character> set, char c) {
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(c)) {
                it.remove();
            } else {
                break;
            }
        }
        it.remove();
        set.add(c);
    }
}
