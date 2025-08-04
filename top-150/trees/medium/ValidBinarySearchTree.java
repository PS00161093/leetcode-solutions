//https://leetcode.com/problems/validate-binary-search-tree/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        inOrder(root, data);
        for(int i = 0; i < data.size() - 1; i++) {
            if(data.get(i) >= data.get(i+1)) {
                return false;
            }
        }

        return true;
    }   

    public void inOrder(TreeNode node, List<Integer> data) {
        if(node != null) {
            inOrder(node.left, data);
            data.add(node.val);
            inOrder(node.right, data);
        }
    }
}
