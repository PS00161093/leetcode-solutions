/**
 * <a href="https://leetcode.com/problems/find-the-k-beauty-of-a-number/">...</a>*
 */
public class NumberBeauty {

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(430043, 2));
    }

    public static int divisorSubstrings(int num, int k) {
        int count = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i <= numStr.length() - k; i++) {
            int tempInt = Integer.parseInt(numStr.substring(i, i + k));
            if (tempInt != 0 && num % tempInt == 0) count++;
        }

        return count;
    }
}
