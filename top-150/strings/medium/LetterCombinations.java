// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(3^N × 4^M) where N is digits with 3 letters, M is digits with 4 letters
// SPACE COMPLEXITY: O(3^N × 4^M) for storing all combinations

class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
                "",
                "",
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(result, map, digits, 0, new StringBuilder());
        return result;
    }

    void backtrack(List<String> result, String[] map, String digits, int index, StringBuilder c) {
        if (index == digits.length()) {
            result.add(c.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (char letter : letters.toCharArray()) {
            c.append(letter);
            backtrack(result, map, digits, index + 1, c);
            c.deleteCharAt(c.length() - 1);
        }
    }
}
