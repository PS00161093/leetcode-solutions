class Solution {
    public int firstUniqChar(String word) {
        int index = -1;
        if (word == null || word.isEmpty()) return index;

        Integer ch = word.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return word.indexOf(ch);
        
    }
}