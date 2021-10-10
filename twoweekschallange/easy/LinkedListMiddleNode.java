package twoweekschallange.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class LinkedListMiddleNode {

    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode c = head;
        while (c != null) {
            list.add(c);
            c = c.next;
        }

        return list.get(list.size() / 2);
    }

}