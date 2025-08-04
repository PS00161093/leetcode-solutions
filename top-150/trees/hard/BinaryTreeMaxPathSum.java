//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);    
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, postOrder(root.left));
        int right = Math.max(0, postOrder(root.right));

        max = Math.max(max, (left + right + root.val));

        return Math.max(left, right) + root.val;
    }
}
