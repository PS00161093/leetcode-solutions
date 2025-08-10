// https://leetcode.com/problems/symmetric-tree/
// Time complexity: O(n)
// Space complexity: O(n)

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        return isSymmetric(root, root);
    }

    boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val &&
                isSymmetric(p.left, q.right) &&
                isSymmetric(p.right, q.left);
    }
}
