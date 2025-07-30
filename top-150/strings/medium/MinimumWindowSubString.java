// https://leetcode.com/problems/minimum-window-substring/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        //build a map with charcount in t
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = tMap.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        Map<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(window.containsKey(c) && window.get(c).equals(tMap.get(c))) {
                have++;
            }

            while(have == need) {
                if((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(tMap.containsKey(leftChar) && 
                    window.get(leftChar) < tMap.get(leftChar)) {
                        have--;
                }

                left++;
            }
        }

        return resLen != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
