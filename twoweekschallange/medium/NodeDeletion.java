package twoweekschallange.medium;

import twoweekschallange.easy.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class NodeDeletion {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        int nodeIndexToRemoveFromFront = length - n;

        return removeNode(head, nodeIndexToRemoveFromFront);
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    private ListNode removeNode(ListNode node, int indexToRemove) {
        int index = 0;
        ListNode res = null;
        while (node != null) {
            if (index != indexToRemove) {
                res = add(res, node.val);
            }
            index++;
            node = node.next;
        }

        return res;
    }

    private ListNode add(ListNode node, int val) {
        if (node == null) return new ListNode(val);
        ListNode c = node;
        while (c.next != null) c = c.next;
        c.next = new ListNode(val);

        return node;
    }

}
