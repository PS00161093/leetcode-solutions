// https://leetcode.com/problems/valid-word-abbreviation/description/

class WordAbbreviation {
  
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }

        int wi = 0;
        int ai = 0;

        while (wi < word.length() && ai < abbr.length()) {
            char c = abbr.charAt(ai);

            if (Character.isDigit(c)) {
                if (c == '0') {
                    return false;
                }

                int num = 0;
                while (ai < abbr.length() && Character.isDigit(abbr.charAt(ai))) {
                    num = num * 10 + (abbr.charAt(ai) - '0');
                    ai++;
                }

                wi = wi + num;
            } else {
                if (c != word.charAt(wi)) {
                    return false;
                }
                wi++;
                ai++;
            }
        }

        return wi == word.length() && ai == abbr.length();
    }
}
