package twoweekschallange.easy;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseStatement {

    public String reverseStatement(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (String value : arr) sb.append(reverse(value)).append(" ");

        return sb.substring(0, sb.length() - 1);
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }

        return String.valueOf(arr);
    }
}
