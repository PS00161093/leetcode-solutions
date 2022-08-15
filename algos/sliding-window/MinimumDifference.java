import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/">...</a>*
 */
public class MinimumDifference {

    public static void main(String[] args) {
        int[] arr = {9, 4, 1, 7};
        int k = 2;
        System.out.println(minimumDifference(arr, k));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
      
        return res;
    }

}
