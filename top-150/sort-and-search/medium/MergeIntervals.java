// https://leetcode.com/problems/merge-intervals
// TIME COMPLEXITY: O(n log n) where n is number of intervals. Sorting dominates at O(n log n), linear scan is O(n)
// SPACE COMPLEXITY: O(n) for the result list. Worst case: no overlaps, store all n intervals

class MergeIntervals {
  
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
      
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                curr = next;
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
