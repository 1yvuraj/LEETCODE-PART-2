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
        if(head==null || head.next==null)return head;
        ListNode dummy=new ListNode(-1000);
        ListNode cur=head.next;
        ListNode pre=dummy;
        dummy.next=head;
        while(cur!=null){
            boolean f=false;
            while(cur!=null && pre.next.val==cur.val){
                f=true;
                cur=cur.next;
            }
            if(f){
                pre.next=cur;
                
            }else{
                pre=pre.next;
            }
            if(cur!=null)cur=cur.next;
        }
        return dummy.next;
    }
}