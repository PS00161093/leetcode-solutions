//https://leetcode.com/problems/one-edit-distance/description/

class OneEditDistance {
  
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) {
            return false;
        }

        int sLen = s.length();
        int tLen = t.length();

        if (Math.abs(sLen - tLen) > 1 || s.equals(t)) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < sLen && j < tLen && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }

        if (sLen > tLen) {
            //only deletion is possible
            return s.substring(i + 1).equals(t.substring(j));
        } else if (sLen < tLen) {
            //only insertion is possible
            return s.substring(i).equals(t.substring(j + 1));
        } else {
            //only replacement is possible
            return s.substring(i + 1).equals(t.substring(j + 1));
        }

    }
}
