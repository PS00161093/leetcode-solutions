// https://leetcode.com/problems/reorder-list/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(n) where n is the number of nodes
// SPACE COMPLEXITY: O(1)

class ReorderList {
  
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle of the list using slow/fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Break the connection
        
        // Step 3: Merge the two halves alternately
        ListNode first = head;
        ListNode second = secondHalf;
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
}
