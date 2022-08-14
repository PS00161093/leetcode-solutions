/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">...</a>*
 */
public class MinSubArrayLen {
    static int target = 7;

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(arr));
    }

    public static int minSubArrayLen(int[] nums) {
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
