package threeweekschallange.medium;

import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 100000;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    k--;
                } else {
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
