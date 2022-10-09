class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target && left <= right) {
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}