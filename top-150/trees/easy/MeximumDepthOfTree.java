// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Time complexity: O(n)
// Space complexity: O(n)

class MeximumDepthOfTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }

        dfs(root, 0);

        return maxDepth;
    }

    void dfs(TreeNode node, int curr) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, curr);
            return;
        }

        dfs(node.left, curr + 1);
        dfs(node.right, curr + 1);
    }
}
