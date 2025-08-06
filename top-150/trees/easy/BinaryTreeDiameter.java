// https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {
    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return dia;
        }

        dfs(root);

        return dia;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lh = dfs(node.left);
        int rh = dfs(node.right);

        dia = Math.max(dia, lh + rh);

        return lh > rh ? lh + 1 : rh + 1;
    }
}
