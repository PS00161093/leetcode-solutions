// https://leetcode.com/problems/reverse-linked-list-ii/description/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 1; i < left; i++) {
            prev = prev.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = prev.next;
        for(int i = left; i <= right; i++) {
            stack.push(curr);
            curr = curr.next;
        }

        while(!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }

        prev.next = curr;

        return dummy.next;
    }
}
