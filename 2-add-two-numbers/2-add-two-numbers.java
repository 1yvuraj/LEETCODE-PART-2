/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(1000);
        ListNode itr = dummy;
        int c = 0;

        while (c1 != null || c2 != null || c != 0) {
            int sum = (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0) + c;
            c = sum / 10;
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            itr.next = node;
            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
            itr = itr.next;
        }
        return dummy.next;
    }
}
