// https://leetcode.com/problems/path-sum/
// SC: O(n) Each node is visited once in the worst case
// TC: O(h) Recursion stack height equals tree height h. Worst-case (skewed tree): O(n); balanced: O(log n)

class PathSum {
  
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int rem = targetSum - root.val;

        return hasPathSum(root.left, rem) || hasPathSum(root.right, rem);
    }
}
