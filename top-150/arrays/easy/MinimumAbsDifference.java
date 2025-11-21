// https://leetcode.com/problems/minimum-absolute-difference

class Solution {
  
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
            set.add(arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(minDiff + arr[i])) {
                res.add(List.of(arr[i], arr[i] + minDiff));
            }
        }

        return res;
    }
}
