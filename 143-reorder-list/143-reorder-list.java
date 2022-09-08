class Solution {

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode rv = reverseList(mid.next);
        mid.next = null;
        ListNode c1 = head;
        ListNode c2 = rv;

        while (c1 != null && c2 != null) {
            ListNode f1 = c1.next;
            ListNode f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            if (fast.next != null) fast = fast.next.next;
            if (slow != null) slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode fr = cur.next;
            cur.next = pre;
            pre = cur;
            cur = fr;
        }
        return pre;
    }
}
