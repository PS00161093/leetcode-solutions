// https://leetcode.com/problems/binary-tree-paths/
// Time Complexity: O(N) where N is number of nodes
// Space Complexity: O(N) for recursion stack and storing paths

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        StringBuilder path = new StringBuilder();
        dfs(root, path, result);

        return result;
    }

    public void dfs(TreeNode node, StringBuilder path, List<String> result) {
        int lengthBeforeAdd = path.length();        

        if(path.length() > 0) {
            path.append("->");
        }
        path.append(node.val);

        if(node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            if(node.left != null) {
                dfs(node.left, path, result);
            }
            if(node.right != null) {
                dfs(node.right, path, result);
            }            
        }

        path.setLength(lengthBeforeAdd);
    }
}
