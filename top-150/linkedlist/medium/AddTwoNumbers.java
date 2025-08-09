// https://leetcode.com/problems/add-two-numbers/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
// TIME COMPLEXITY: O(n) where n is the length of nums array
// SPACE COMPLEXITY: O(min(n,k)) HashMap stores at most min(n,k) remainders. At most k different remainders (0 to k-1) or n elements total

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
