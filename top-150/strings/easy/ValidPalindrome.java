// https://leetcode.com/problems/valid-palindrome/description/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        return sb.toString().equals(sb.reverse().toString());
    }
}
