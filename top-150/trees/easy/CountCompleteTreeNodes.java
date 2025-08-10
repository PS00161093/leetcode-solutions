// https://leetcode.com/problems/count-complete-tree-nodes/description/
// TC: O((log n)²)
// SC: O(log n)

class CountCompleteTreeNodes {
  
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            // left subtree is perfect: size = 2^left - 1; + 1 for root
            return (1 << left) + countNodes(root.right);
        } else {
            // right subtree is perfect: size = 2^right - 1; + 1 for root
            return (1 << right) + countNodes(root.left);
        }
    }

    int depth(TreeNode node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left; // because ndoe will on left
        }
        return d;
    }
}
