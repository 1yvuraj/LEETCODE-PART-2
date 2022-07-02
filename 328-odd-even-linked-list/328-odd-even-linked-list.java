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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode dummy1=new ListNode(-1);
        ListNode p=dummy;
        ListNode p1=dummy1;
        ListNode cur=head;
        int idx=1;
        while(cur!=null){
            if(idx%2==0){
                p.next=cur;
                p=cur;
                
            }else{
                p1.next=cur;
                p1=cur;
            }
            idx++;
            if(cur!=null)cur=cur.next;
        }
        p1.next=dummy.next;
        p.next=null;
        return dummy1.next;
        
    }
}