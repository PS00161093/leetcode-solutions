//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class FlattenToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        TreeNode currLevel=null;
        while(!s.isEmpty()){
            TreeNode curr=s.pop();
            if(currLevel!=null){
                currLevel.left=null;
                currLevel.right=curr;
            }
            if(curr.right!=null) s.push(curr.right);
            if(curr.left!=null) s.push(curr.left);
            currLevel=curr;
        }
    }
}
