// https://leetcode.com/problems/ransom-note/

class RansoneNote {
  
    public boolean canConstruct(String ransomNote, String magazine) {
        // Count frequency of characters in magazine
        int[] charCount = new int[26];
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
