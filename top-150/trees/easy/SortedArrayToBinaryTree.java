// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// Time complexity: O(N)
// Space complexity: O(logN), The recursion stack requires O(logN) space because the tree is height-balanced. 

class SortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);

        return root;
    }
}
