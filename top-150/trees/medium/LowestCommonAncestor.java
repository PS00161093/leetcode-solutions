// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();

        findPath(root, p, pathToP);
        findPath(root, q, pathToQ);

        TreeNode lca = null;
        int minLen = Math.min(pathToP.size(), pathToQ.size());

        for (int i = 0; i < minLen; i++) {
            if (pathToP.get(i) == pathToQ.get(i)) {
                lca = pathToP.get(i);
            } else {
                break;
            }
        }

        return lca;
    }

    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == target) {
            return true;
        }

        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    // Another solution, O(n), O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
    
        if(root == p || root == q) {
            return root;
        }
    
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
    
        if(left != null && right!= null) {
            return root;
        }
    
        return left != null ? left : right;
    }  
}
