// https://leetcode.com/problems/maximum-number-of-words-you-can-type/

class Solution {
  
    public int canBeTypedWords(String text, String brokenLetters) {
      
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray())
            broken.add(c);

        String[] words = text.split(" ");
        int success = 0;
      
        for (String word : words) {
            success++;
            for (char c : word.toCharArray()) {
                if (broken.contains(c)) {
                    success--;
                    break;
                }
            }
        }

        return success;
    }
}
