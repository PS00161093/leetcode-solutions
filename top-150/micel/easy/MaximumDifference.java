// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/

class MaximumDifference {
  
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replaceAll(s.charAt(pos) + "", "9");
        }
        
        t = t.replaceAll(t.charAt(0) + "", "0");
        
        return Integer.parseInt(s) - Integer.parseInt(t);
    }    
}
