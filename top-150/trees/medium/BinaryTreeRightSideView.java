//https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        if (null == root) {
            return result;
        }

        queue.add(root);
      
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = queue.remove();
                if (i == size - 1) {
                    result.add(c.val);
                }
                if (c.left != null) {
                    queue.add(c.left);
                }
                if (c.right != null) {
                    queue.add(c.right);
                }
            }
        }

        return result;
    }
}
