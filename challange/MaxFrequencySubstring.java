import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/">...</a>
 */
public class MaxFrequencySubstring {
    public static void main(String[] args) {
        String str = "bccaabac";
        int maxLetters = 2;
        int minSize = 2;
        int maxSize = 2;
        System.out.println(maxFreq(str, maxLetters, minSize, maxSize));
    }

    // 39/40 test cases passed. Got timeLimitExceeded for the last one.
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Set<String> constrainedSubStrings = new HashSet<>();
        getSubStringsWithinLimits(s, minSize, constrainedSubStrings, maxLetters);
        if (minSize != maxSize) {
            getSubStringsWithinLimits(s, maxSize, constrainedSubStrings, maxLetters);
        }

        return getMaxFreq(constrainedSubStrings, s);
    }

    private static void getSubStringsWithinLimits(String s, int size, Set<String> constrainedSubStrings, int maxLetters) {
        for (int i = 0; i < s.length() - size + 1; i++) {
            String subStr = s.substring(i, i + size);
            int uniqueLetters = subStr.chars()
                    .mapToObj(ch -> (char) ch)
                    .collect(Collectors.toSet())
                    .size();
            if (uniqueLetters <= maxLetters) {
                constrainedSubStrings.add(subStr);
            }
        }
    }

    private static int getMaxFreq(Set<String> constrainedSubStrings, String orgStr) {
        int count = 0;
        for (String str : constrainedSubStrings) {
            int currCount = 0;
            Pattern pattern = Pattern.compile(Pattern.quote(str));
            Matcher matcher = pattern.matcher(orgStr);
            int position = 0;
            while (matcher.find(position)) {
                position = matcher.start() + 1;
                currCount++;
            }
            count = Math.max(count, currCount);
        }

        return count;
    }
    
    //All test cases passed
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0 || maxLetters == 0) return 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String subString = s.substring(i, i + minSize);
            if (isValid(subString, maxLetters)) {
                map.put(subString, map.getOrDefault(subString, 0) + 1);
                max = Math.max(max, map.get(subString));
            }
        }
        
        return max;
    }

    static boolean isValid(String subString, int maxLetters) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : subString.toCharArray()) hs.add(c);
        return hs.size() <= maxLetters;
    }

}
