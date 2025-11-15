// https://leetcode.com/problems/summary-ranges/

class Solution {
  
    public List<String> summaryRanges(int[] nums) {
      List<String> result = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
          int start = i;
          while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
              i++;
          }

          if (start == i) {
              result.add(String.valueOf(nums[start]));
          } else {
              result.add(nums[start] + "->" + nums[i]);
          }
      }

      return result;
    }
}
