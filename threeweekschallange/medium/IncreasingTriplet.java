package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTriplet {

    public static boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) return false;

        Integer num1 = nums[0];
        Integer num2 = null;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= num1) {
                num1 = nums[i];
            }
            else {
                if (num2 != null && nums[i] > num2) return true;
                num2 = nums[i];
            }
        }

        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int z : nums) {
            if (x >= z) x = z;
            else if (y >= z) y = z;
            else return true;
        }

        return false;
    }
}
