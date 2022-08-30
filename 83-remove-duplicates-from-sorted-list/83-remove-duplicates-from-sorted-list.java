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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-10);
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(pre.val!=cur.val){
                pre.next=cur;
                pre=cur;
            }
            if(cur!=null)cur=cur.next;
        }
        pre.next=null;
        return dummy.next;
    }
}