package threeweekschallange.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int a = 0, b = 0;
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(target - n)) {
                a = n;
                b = target - n;
            } else set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                a = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == b) {
                b = i;
                break;
            }
        }

        return new int[]{a, b};

    }
}
