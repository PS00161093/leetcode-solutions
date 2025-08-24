// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/

class MaxSubArraySumAfterDeletion {
  
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                set.add(n);
            }
        }

        if (set.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }

        int sum = 0;
        for (int n : set) {
            sum = sum + n;
        }

        return sum;
    }
}
