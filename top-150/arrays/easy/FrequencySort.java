// https://leetcode.com/problems/sort-array-by-increasing-frequency

class Solution {
  
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[idx] = entry.getKey();
                idx++;
            }
        }

        return nums;
    }
}
