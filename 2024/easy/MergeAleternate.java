public class MergeAleternate {
    public static void main(String[] args) {
        String output = mergeAlternately("abc", "pqr");
        System.out.println(output);
    }

    public static String mergeAlternately(String word1, String word2) {
        if (null == word1 || word1.trim().isEmpty()) {
            return word2;
        }
        if (null == word2 || word2.trim().isEmpty()) {
            return word1;
        }

        int i = 0;
        int j = 0;
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();

        while (i < arr1.length && j < arr2.length) {
            sb.append(arr1[i]).append(arr2[j]);
            i++;
            j++;
        }

        if (i < arr1.length) {
            sb.append(word1, i, arr1.length);
        } else {
            sb.append(word2, j, arr2.length);
        }

        return sb.toString();
    }
}
