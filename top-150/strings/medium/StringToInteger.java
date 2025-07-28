// https://leetcode.com/problems/string-to-integer-atoi/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class StringToInteger {
    public int myAtoi(String s) {
        long num = 0;
        s = s.trim();
        if (s.isEmpty())
            return 0;

        int i = 0;
        int sign = 1;
        char signChar = s.charAt(i);
        if (signChar == '+' || signChar == '-') {
            sign = signChar == '-' ? -1 : 1;
            i++;
        }

        int len = s.length();
        while (i < len && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (num * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }

        return (int) num * sign;
    }
}
