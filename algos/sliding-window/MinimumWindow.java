import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">...</a>
 */
class MinimumWindow {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int tUniqueLettersCount = tMap.size();

        // Left and Right pointer
        int left = 0, right = 0;

        /*
         formed is used to keep track of how many unique characters in t
         are present in the current window in its desired frequency.
         e.g. if t is "AABC" then the window must have two A's, one B and one C.
         Thus formed would be = 3 when all these conditions are met.
         */
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowMap = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            int count = windowMap.getOrDefault(c, 0);
            windowMap.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increase the formed count by 1.
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (left <= right && formed == tUniqueLettersCount) {
                c = s.charAt(left);
                // Save the smallest window until now.
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowMap.put(c, windowMap.get(c) - 1);
                if (tMap.containsKey(c) && windowMap.get(c) < tMap.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                left++;
            }

            // Keep expanding the window once we are done contracting.
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
