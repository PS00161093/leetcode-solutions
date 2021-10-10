package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {

    /**
     * O(n)
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }

        return res;
    }

    /**
     * O(n^2)
     */
    public static int[] productExceptSelf1(int[] nums) {

        int[] res = new int[nums.length];
        int pro = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pro = pro * nums[j];
            }
            for (int j = i - 1; j >= 0; --j) {
                pro = pro * nums[j];
            }
            res[i] = pro;
            pro = 1;
        }

        return res;
    }
}
