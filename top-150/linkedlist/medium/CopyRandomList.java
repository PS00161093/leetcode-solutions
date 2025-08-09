// https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(n) where n is the number of nodes
// SPACE COMPLEXITY: O(n)

class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copiedNode = map.get(curr);
            if (curr.next != null) {
                copiedNode.next = map.get(curr.next);
            }

            if (curr.random != null) {
                copiedNode.random = map.get(curr.random);
            }

            curr = curr.next;
        }

        return map.get(head);
    }
}
