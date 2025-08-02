// https://leetcode.com/problems/product-of-array-except-self/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] postfix = new int[len];

        int i = 0;
        while (i < len) {
            prefix[i] = i == 0 ? nums[i] : nums[i] * prefix[i - 1];
            i++;
        }

        int j = len - 1;
        while (j >= 0) {
            postfix[j] = j == len - 1 ? nums[j] : postfix[j + 1] * nums[j];
            j--;
        }

        nums[0] = postfix[0 + 1];
        nums[len - 1] = prefix[len - 1 - 1];

        for (int a = 1; a < len - 1; a++) {
            nums[a] = prefix[a - 1] * postfix[a + 1];
        }

        return nums;
    }
}
