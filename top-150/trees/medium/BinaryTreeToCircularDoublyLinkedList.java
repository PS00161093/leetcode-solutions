// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class BinaryTreeToCircularDoublyLinkedList {
    Node prev = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        prev = null;
        head = null;

        inOrder(root);

        head.left = prev;
        prev.right = head;

        return head;
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }

        prev = node;

        inOrder(node.right);
    }

}
