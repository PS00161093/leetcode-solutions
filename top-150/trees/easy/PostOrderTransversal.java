// https://leetcode.com/problems/binary-tree-postorder-traversal/

class PostOrderTransversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list);
        return list;
    }

    void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }
}
