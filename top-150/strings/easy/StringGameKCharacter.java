// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/

class StringGameKCharacter {
  
    public char kthCharacter(int k) {
        // Find how many times we need to double the string
        int length = 1;
        int operations = 0;
        while (length < k) {
            length *= 2;
            operations++;
        }

        // Work backwards to find the character
        int pos = k - 1; // Convert to 0-indexed
        int shifts = 0;

        for (int i = operations - 1; i >= 0; i--) {
            int halfLength = 1 << i; // 2^i
            if (pos >= halfLength) {
                shifts++; // This position came from the "next" part
                pos -= halfLength;
            }
        }

        return (char) ('a' + shifts);
    }
}
